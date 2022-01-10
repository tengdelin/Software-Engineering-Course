import random
import time

from BasicTest import *

class TimeOutTest(BasicTest):
    def handle_packet(self):
        for p in self.forwarder.in_queue:
            if random.choice([True, False, False]):
                time.sleep(random.random() * 0.6)
                self.forwarder.out_queue.append(p)

        # empty out the in_queue
        self.forwarder.in_queue = []
