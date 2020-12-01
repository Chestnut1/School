"""
Author: Bruno Luca
Date: 23-10-2020
Es: Create a tcp multithread server
"""

import socket
import threading

ip = "127.0.0.1"
port = 7000

connection_table = {}   #store connected end point
active_thread = []      #store running threads

class ClietThread(threading.Thread):
    """
    docstring
    """
    def __init__(self,ip,port,connection): #contructor
        threading.Thread.__init__(self)

        self.ip_address = ip
        self.port = port
        self.connection = connection
        self.again = 1


    def run(self):  #codice che esegue il thread
        while self.again:
            msg = self.connection.recv(4096)
            msg = msg.decode()
            print(f"{ip},{port}>> {msg}")
            self.connection.sendall(msg.encode())

            if msg == "close":
                print(f"{self.connection}>> want to exit.")
                self.again = 0

def close_thread(t):
    if t in active_thread:
        active_thread[active_thread.index(t)].join()
        active_thread.pop(active_thread.index(t))
        

def server():
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    s.bind((ip,port))

    while True:
        #new connection
        s.listen()
        print("\n\tSERVER IS LISTENING...\n")
        conn, add = s.accept()
        print("\n\tNEW USER CONNECTED!!\n")
        t = ClietThread(add[0],add[1],conn)
        t.start()

        #updating tables
        active_thread.append(t)
        connection_table[conn] = add

if __name__ == "__main__":
    server()