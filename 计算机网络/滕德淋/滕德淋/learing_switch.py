from sim.api import *
from sim.basics import *

'''
Create your RIP router in this file.
'''
class LearningSwitch (Entity):
    def __init__(self):
        # Add your code here!
        self.ports= {}

    def handle_rx (self, packet, port):
        # Add your code here!
        packetDest = packet.dst;
        if not self.ports.has_key(packet.src):   
        	self.ports[packet.src] = port;

        if self.ports.has_key(packetDest):
        	self.send(packet, self.ports[packetDest])
        else:
        	self.send(packet, port, flood=True)
        # raise NotImplementedError
