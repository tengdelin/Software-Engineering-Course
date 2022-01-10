from math import log
import sys
import getopt
from datetime import datetime
import os
import math
import threading


import Checksum
import BasicSender

'''
This is a skeleton sender class. Create a fantastic transport protocol here.
'''
class Sender(BasicSender.BasicSender):
	def __init__(self, dest, port, filename, debug=False):
		super(Sender, self).__init__(dest, port, filename, debug)

		#Number of times to retry connection. Make it very large so we keep bothering receiver 5ever before it talks to us. Don't ignore us bitch
		self.retry_count = 10000000000000
		# 0.5 Second timeout (500ms)
		self.timeout = 0.5
		#Max Payload
		self.max_payload = 1472
		#Window Size
		self.wind_size = 5
		#Buffering Packets To Send (Seq #, (inflight, data))
		self.buffer = dict()
		#Determining Number of Packets to Send
		file_size = os.fstat(self.infile.fileno()).st_size
		self.num_packets = math.ceil(float(file_size) / self.max_payload)
		# print self.num_packets
		# print "the sum of package is:"
		print "the sum of package is: %d" % (self.num_packets)
		#For DUP ACKS
		self.prev_ack = None
		self.dup_ack_count = 0
		self.dup_ack_max = 3

	# Main sending loop.
	def start(self):
		print "===== Hello,Welcome to xiaoteng Sender! ====="
		self.isn = 0

        # self.initialize_connection initializes the connection
        # and self.send_base, which maintains the invariant that
        # it is always the seqno of the leftmost packet in window
		if (self._initialize_connection(self.retry_count)):#connect success

			#Edge case where we have no data to send   # have no data to send
			if self.num_packets > 0:
				#Send first window of packets
				self._initialize_and_send_buffer()

				#Start listening for acks and advance sliding window as needed
				self._listen_for_acks()

			#Done sending everything!
			if self._tear_down_connection(self.retry_count):
				pass
			else:
				print "Could not tear down connection. Will just assume it is gone sever"
				pass
		else:
			print "Could not connect to the receiving socket"
			pass

	def _initialize_and_send_buffer(self):
		# Remove all items in buffer less than self.send_base.
        # For cleanup purposes
		for seqno in self.buffer.keys():
			if seqno < self.send_base:
				del self.buffer[seqno]

		#Add up to WIND_SIZE packets into the buffer
		for i in range(self.wind_size): # i = 0,1,2,3,4, ...
			seqno = self.send_base + i
			if self.buffer.has_key(seqno):
                #We already have this packet in the buffer
				pass
			else:
				data = self.infile.read(self.max_payload)
				if data:
					#We have data!
					self.buffer[seqno] = data

					#We only transmit new data
					self._transmit(seqno)
				else:
					#We ran out of data
					break

	def _listen_for_acks(self):
		self.time_til_timeout = self.timeout
		while True:
			#Always listen for acks
			start_time = datetime.now()
			response = self.receive(timeout=self.time_til_timeout)
			end_time = datetime.now()
			delta = end_time - start_time
			time_elapsed = delta.seconds + delta.microseconds/1E6
			self.time_til_timeout = max(self.time_til_timeout - time_elapsed, 0)
			print self.time_til_timeout
			if response:
				if Checksum.validate_checksum(response):
						#Good Packet!
						msg_type, seqno, data, checksum = self.split_packet(response)
						if msg_type != "ack":
							continue
						ack = int(seqno)
						if ack < self.send_base:
							continue
						if self.handle_new_ack(ack):
							return
				else:
					#Not good packet! Listen for acks again
					pass
			else:
				#TIMEOUT!
				self.handle_timeout()

	def _transmit(self, seqno):
			#Send a single packet.
		msg_type = "data"
		if self.buffer.has_key(seqno):
			data = self.buffer[seqno]

			print "TRANSMITED: %d" % (seqno - self.isn)
			packet = self.make_packet(msg_type, seqno, data)
			self.send(packet)

	def _initialize_connection(self, retry_count):
		#Three Way Handshake
		print "Three Handshake Success !"
		if retry_count > 0:
			#Fields of the packet
			msg_type = 'start'
			msg = ""
			#Create and send the initlization packet
			start_packet = self.make_packet(msg_type, self.isn, msg)
			self.send(start_packet)
			#Wait 500ms to receive the packet
			response = self.receive(timeout=self.timeout)
			if response:
				if Checksum.validate_checksum(response):
					#Good Packet!
					msg_type, seqno, data, checksum = self.split_packet(response)
					ack = int(seqno)
					if msg_type == "ack" and ack == self.isn + 1:
						self.send_base = ack
						return True
					else:
						return self._initialize_connection(retry_count - 1)
				else:
					#Not good packet!
					return self._initialize_connection(retry_count - 1)
			else:
				#Timeout
				return self._initialize_connection(retry_count - 1) 
		else:
			#Could not connect
			return False      

	def _tear_down_connection(self, retry_count):
		print "TEAR DOWN THIS WALL"
		if retry_count > 0:
			#Fields of the packet
			msg_type = 'end'
			msg = ""
			#Create and send the tear down packet
			tear_down_packet = self.make_packet(msg_type, self.send_base, msg)
			self.send(tear_down_packet)
			#Wait 500ms to receive the packet
			response = self.receive(timeout=self.timeout)
			if response:
				if Checksum.validate_checksum(response):
					#Good Packet!
					msg_type, seqno, data, checksum = self.split_packet(response)
					seqno = int(seqno)
					if seqno >= self.send_base + 1 and msg_type == "ack":
						return True
					else:
						#Wrong SEQ NO EXPECTED
						return self._tear_down_connection(retry_count - 1)
				else:
					#Not good packet!
					return self._tear_down_connection(retry_count - 1)
			else:
				#Timeout
				return self._tear_down_connection(retry_count - 1) 
		else:
			#Could not tear down packet. Should we just stop sending messages?
			return False     


	def handle_timeout(self):
		print "TIMEOUT!"
		#Timeout Function. Just resubmit all packets in buffer
		for i in range(self.wind_size):
			seqno = self.send_base + i
			if self.buffer.has_key(seqno):
				self._transmit(seqno)
		self.time_til_timeout = self.timeout

	def handle_new_ack(self, ack):
		#Returns True if we are done sending file, False otherwise
		print "ACK: %d" % (ack - self.isn)

		#Dup Acks
		if self.prev_ack is not None and self.prev_ack == ack:
			self.dup_ack_count += 1
			if self.dup_ack_count >= self.dup_ack_max:
				self.handle_dup_ack(ack)
		else:
			self.dup_ack_count = 0

		self.prev_ack = ack

		if ack > self.send_base:
			#We can move our window forward!
			self.send_base = ack
			self.time_til_timeout = self.timeout
			if self.send_base - self.isn > self.num_packets:
				#We received an ack for a packet seqno. greater than the num of packets we need to send. We are DONE!
				return True
			else:
				#Buffer more packets and send them
				self._initialize_and_send_buffer()

		return False

	def handle_dup_ack(self, ack):
		print "DUP ACK: %d" % (ack - self.isn)
		if self.buffer.has_key(ack):
			self._transmit(ack)

	def log(self, msg):
		if self.debug:
			print msg

'''
This will be run if you run this script from the command line. You should not
change any of this; the grader may rely on the behavior here to test your
submission.
'''
if __name__ == "__main__":
	def usage():
		print "BEARS-TP Sender"
		print "-f FILE | --file=FILE The file to transfer; if empty reads from STDIN"
		print "-p PORT | --port=PORT The destination port, defaults to 33122"
		print "-a ADDRESS | --address=ADDRESS The receiver address or hostname, defaults to localhost"
		print "-d | --debug Print debug messages"
		print "-h | --help Print this usage message"

	try:
		opts, args = getopt.getopt(sys.argv[1:],
							   "f:p:a:d", ["file=", "port=", "address=", "debug="])
	except:
		usage()
		exit()

	port = 33122
	dest = "localhost"
	filename = "README"
	debug = False

	for o,a in opts:
		if o in ("-f", "--file="):
			filename = a
		elif o in ("-p", "--port="):
			port = int(a)
		elif o in ("-a", "--address="):
			dest = a
		elif o in ("-d", "--debug="):
			debug = True

	s = Sender(dest,port,filename,debug)
	try:
		s.start()
		
	except (KeyboardInterrupt, SystemExit):
		exit()
