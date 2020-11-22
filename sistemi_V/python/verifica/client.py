"""
Author: Bruno Luca
Date: 20-11-2020
"""

import os
import math
import sqlite3
import logging as log
import threading
import socket
import config

def main():
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client.connect((config.SERVER_IP,config.SERVER_PORT))

    while True:
        #receive operation and process it
        op = client.recv(4096)
        op = op.decode()
        print(op)
        
        if op == "exit":
            break
        try:
            result = str(eval(op))
            client.sendall(result.encode())
        except:
            log.error(f" error executing {op}")
            client.sendall("ERROR".encode())
        
    client.close()

    print("connection to [{SERVER_IP},{SERVER_PORT}] closed, press any key to terminate process...")

if __name__ == "__main__":
    main()