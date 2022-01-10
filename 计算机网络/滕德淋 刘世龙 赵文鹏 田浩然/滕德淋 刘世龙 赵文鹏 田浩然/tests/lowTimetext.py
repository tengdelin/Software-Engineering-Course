import random
import Queue
from BasicTest import *
q = Queue.Queue(3)
class lowTimetext(BasicTest):
    def handle_packet(self):
        for p in self.forwarder.in_queue:
            q.put(p)
            if q.full():
                f=q.get()
                self.forwarder.out_queue.append(f)


        # empty out the in_queue
        self.forwarder.in_queue = []
