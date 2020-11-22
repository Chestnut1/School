"""
Author: Bruno Luca
Date: 02-11-2020
"""


import os
import math
import sqlite3
import logging as log
import threading
import config
import socket

#global counter for clients
client_count = 1

#data structures
operations = {}
clients = {}

#setting db path
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
db_name = os.path.join(BASE_DIR, "operations.db")

def load_data():
    """
    load db data in operations dictionary
    {
        "math operation",thred number
        .
        .
        .
    }
    """

    #read data from db
    with sqlite3.connect(db_name) as db_conn:
        cursor = db_conn.cursor()
        cursor.execute("SELECT client,operation  FROM operations")
        raw_data = cursor.fetchall()

        #load data into data structure
        for t in raw_data:  #raw_data = [(1, '5+6*(454483+3447)') , ....]
            operations[t[1]] = t[0]



class CLientThread(threading.Thread):
    def __init__(self,ip,port,connection,index):
        self.index = index
        threading.Thread.__init__(self)
        self.ip = ip
        self.port = port
        self.connection = connection
        self.close = False

        #load operations to execute in a list
        self.operation2execute = []
        for k,v in operations.items():
            if v == self.index:
                self.operation2execute.append(k)
        
        

    def run(self):
        #execute all operations in the list
        while True:
            if len(self.operation2execute) == 0:
                break

            command = self.operation2execute.pop(0)
            self.connection.sendall(command.encode())

            result = self.connection.recv(4096) #wait for result from client

            log.info(f"{command} = {result.decode()} from {self.ip} - {self.port}\n")

        self.connection.sendall("exit".encode())

            

            

    

def main():

    load_data()

    #configuring log message
    log.basicConfig(format = "%(asctime)s: %(message)s", level = log.INFO, datefmt = "%H:%M:%S")
    log.basicConfig(format = "%(asctime)s: %(message)s", level = log.ERROR, datefmt = "%H:%M:%S")

    server = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    server.bind((config.SERVER_IP,config.SERVER_PORT))

    #connection scanner
    while True:
        global client_count

        server.listen()

        #log.info("\tSERVER IS LISTENING\n")

        conn,add = server.accept()

        #log.info(f"\t[{add[0]},{add[1]}] CONNECTED")

        client = CLientThread(add[0],add[1],conn,client_count)
        client_count = client_count + 1

        client.start()

    




if __name__ == "__main__":
    main()