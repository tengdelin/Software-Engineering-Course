import random
import time

from BasicTest import *

class LayoutTest(BasicTest):
    def handle_packet(self):
        for p in self.forwarder.in_queue:
            lag = time.sleep(random.random() * 100)
            i = 0
            while i < lag:
                self.forwarder.out_queue.append('lag')
            self.forwarder.out_queue.append(p)

        # empty out the in_queue
        self.forwarder.in_queue = []
