"""
Author: Bruno Luca
Date: 03-06-2020
"""

import threading
import logging
import time
import random

MAX_CLIENT = 30
inside = 0  #clients inside the shop
actually_serverd = 0    #total served clients


def cassa(index):
    global inside
    global actually_serverd

    checkout_mutex.acquire()

    logging.info(f"CHECKOUT: managing client {index}...")
    time.sleep(random.randrange(1,2))   #random time before client finish his purchase
    logging.info(f"CHECKOUT: client {index} paid {random.randrange(1,250)}, checkout is now free\n")
    actually_serverd = actually_serverd+1
    inside = inside - 1 #more space available

    checkout_mutex.release()
    

def enter(index):
    global inside
    
    if inside<MAX_CLIENT:
        inside = inside+1
        logging.info(f"\nclient {index} entered the shop. ({MAX_CLIENT-inside} available)\n")
        time.sleep(random.randrange(1,2))   #wait some times before going to the checkout
        cassa(index)


if __name__ == "__main__":
    #setting logging messages
    format = "%(asctime)s: %(message)s"
    logging.basicConfig(format = format, level = logging.INFO, datefmt = "%H:%M:%S") 

    #creating mutex
    checkout_mutex = threading.Lock()

    random_clients = random.randrange(30,MAX_CLIENT*2)
    logging.info(f"\n{random_clients} HAVE BEEN GENERATED\n")

    #creating threads and starting them
    t = [threading.Thread(target = enter, args = (i+1, )) for i in range(0,random_clients)]  #creating between 15 and 50 threads
    for k in t:
        k.start()
        time.sleep(1)   #every sec one more client arrive

    #wait for threads to end
    for r in t:
        r.join()

    logging.info(f"\n{actually_serverd} CLIENTS HAVE BEEN SERVED\n")