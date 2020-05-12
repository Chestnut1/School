import threading
import time
import logging as log
import random


#common resources
c1 = threading.Lock()
tickets = 30
customers = 20

def cassa(index):
    global tickets
    #cassa 1
    c1.acquire()
    t = random.randrange(1,3)   #client's tickets
    print(f"Hi, i'm {index} and i want to buy {t} tickets...")
    if tickets == 0:
        print("NO MORE TICKETS AVAILABLE!")
    elif tickets > 0 and t <= tickets:
        print(f"{t} tickets bought.")
        tickets = tickets - t
    elif tickets > 0 and t > tickets:
        print(f"{tickets} tickets bought.")
        tickets = 0

    print(f"TICKETS AVAILABLE: {tickets}")
    c1.release()


def main():
    global customers

    #configuring log message info
    format = "%(asctime)s: %(message)s"
    log.basicConfig(format = format, level = log.INFO, datefmt= "%H:%M:%S")

    log.info("FATHER, creating threads...")

    clients = []

    #creating threads
    for i in range(0,customers):
        clients.append(threading.Thread(target = cassa, args = (i+1, )))

    #starting threads
    for c in clients:
        c.start()

    #kill all threads
    for c in clients:
        c.join()

if __name__ == "__main__":
    main()