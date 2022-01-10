from sim.api import *
from sim.basics import *

'''
Create your RIP router in this file.
'''
class RIPRouter (Entity):
    	def __init__(self):
		# Add your code here!
		self.routingTable = {} #routingTable = { 'a' : {'a':1 , 'b': 2}, 'b': {'b':1 , 'c':2}}
		self.minCosts = {}
		self.ports = {}
		self.lastPackets= {}

	def handle_rx (self, packet, port):
		
		def min_by_port(lst):
			lowers = []
			for index, (key,value) in enumerate(sorted(lst, key=lambda x: x[1])):
				if index == 0:
					lowers.append( (key,value))
				elif value  == lowers[0][1]:
					lowers.append( (key,value))
			return min(lowers, key=lambda x: self.ports[x[0]])
		
		def update_min_costs():
			"""This function generates destDict from routingTable (basically the same as routingTable but ordered by destination)
			it is current HIGHLY inefficient, costing O(n^2) time. fix it maybe? """
			preChange = self.minCosts.copy()
			#print "premin = ", preChange
			destDict = {}
			for row in self.routingTable: #each row is the neighbour
				for dest in self.routingTable[row]: #the dictionary has a whole bunch of "dest, cost" values
					cost = self.routingTable[row][dest]
					if destDict.has_key(dest):
						lst = destDict[dest]
						lst.append((row,cost))
						destDict[dest] = lst # through row, costing cost
					else:
						destDict[dest] = [(row,cost)]

			for dest in destDict: #destdict is each destination and the cost to get through it, and who its through
				self.minCosts[dest] = min_by_port(destDict[dest])

			#print " mincosts is ", self.minCosts,  "changed  = ", preChange != self.minCosts
			return preChange != self.minCosts

		def gen_update(to):
			""" Takes minCosts and generates a routingUpdate from it, specific to the "to" destination"""
			updatePacket = RoutingUpdate()
			for dest in self.minCosts: #for each dest
				if dest != to: # if its not where im sending
			 		if self.minCosts[dest][0] == to:
						 updatePacket.add_destination(dest, 100)
					else:
						updatePacket.add_destination(dest, self.minCosts[dest][1])
			return updatePacket

		#main body	
		print self, " got ", packet, " at ", port

		if hasattr(packet, 'is_link_up'): # DISCOVERY PACKET!
			self.ports[packet.src] = port #how to get to my neighbours
			if packet.is_link_up:
				self.routingTable[packet.src] =  {packet.src: 1}
			else:
				self.routingTable.pop(packet.src)

		elif hasattr(packet, 'paths'): # UPDATE PACKET!

			#print "Routing update is ", packet.str_routing_table();
			if not self.routingTable.has_key(packet.src): #if its not a neighbour, fuck it
				pass
			else: #its a neighbour, deal with it
				for dest in packet.all_dests():
					if packet.get_distance(dest) == 100:
						self.routingTable[packet.src][dest] = 100
					else:	
						throughSrc = self.minCosts[packet.src][1] + packet.get_distance(dest)
						#if not self.routingTable[packet.src].has_key(dest) or  throughSrc < self.routingTable[packet.src][dest]: #no info for dest through src
						self.routingTable[packet.src][dest] = throughSrc

			self.lastPackets[packet.src] = packet

		else: #DATA PACKET!
			if self.minCosts.has_key(packet.dst):
				#print "Trying to send to ", packet.dst, " through ", self.minCosts[packet.dst]
				if self.minCosts[packet.dst][1] != 100:
					self.send(packet, self.ports[self.minCosts[packet.dst][0]]) # data packet, send it through the least cost port


		if update_min_costs(): #regenerate the mincost table, returns true if its changed
			for outport in self.routingTable: #each of my neighbours
				updatePacket = gen_update(outport)
				#print "Sending ", updatePacket.str_routing_table(), " to ", outport
				if len(updatePacket.all_dests()) > 0:
					self.send(updatePacket, self.ports[outport]) #send an update
		
		# print "routing table is ", self.routingTable
		# print "mincost table is ", self.minCosts
		# print ""
