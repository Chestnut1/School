"""
Author: Bruno Luca
Date: 25-04-2020

This program create a client process that comunicate whit serevr.py in local host
"""

import socket

ip = '127.0.0.1'
port = 5000

def main():
    client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

    while(True):
        msg = input(">>")

        client.sendto(msg.encode(),(ip,port))

        if str(msg) == ".shutdown":
            break

    client.close()

if __name__ == "__main__":
    main()

