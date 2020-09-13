"""
Author: Bruno Luca
Date: 11-09-2020
Title: this program create a multithread server capable to comunicate simultaneously with more than 2 client
"""

import socket
import threading

server_ip = "127.0.0.1"
server_port = 5000
server_table = {}

def client():
    connection, address = server.accept()
    while(True):
        msg = connection.recv(4096)
        if msg == "exit":
            break
        else:
            print(f"{address}>> {msg.decode()}" )

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

def main():
    server.bind((server_ip,server_port))
    server.listen()
    
    clients = [threading.Thread(target=client)]

    while True:
        pass










if __name__ == "__main__":
    main()