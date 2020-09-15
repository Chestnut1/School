"""
Author: Bruno Luca
Date 11-09-2020
Title: this program create a client process capable to send numbers and string in local host
"""

import socket

server_ip = "127.0.0.1"
server_port = 5000

def main():
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client.connect((server_ip,server_port))

    while True:
        msg = input("CLIENT>>")

        client.sendall(msg.encode())

        if msg == "quit":
            break
    
    client.close()

if __name__ == "__main__":
    main()