"""
Author: Bruno Luca
Date: 23-10-2020
Es: Create a tcp multithread server
"""

import socket
import threading

server_ip = "127.0.0.1"
server_port = 7000

def client():
    c = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

    c.connect((server_ip,server_port))

    while True:
        msg = input(">>")
        c.sendall(msg.encode())
        echo_msg = c.recv(4096)
        print(f"ECHO>> {echo_msg}")
        if msg == "close":
            input()
    
    c.close()


if __name__ == "__main__":
    client()