"""
Author: Bruno Luca
Date: 11-09-2020
Title: this program create a multithread server capable to comunicate simultaneously with more than 2 client
"""

import socket
import threading

server_ip = "127.0.0.1"
server_port = "5000"

def initialize_listener():
    listener = threading.Lock()
    sender = threading.Lock()

def main():
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind((server_ip,server_port))
    server.listen()

    





if __name__ == "__main__":
    main()