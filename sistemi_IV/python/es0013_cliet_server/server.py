"""
Author: Bruno Luca
Date: 25-04-2020

This program create a server process that comunicate whit client.py in local host
"""

import socket

ip = '127.0.0.1'
port = 5000




def main():
    server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

    server.bind((ip,port))

    while(True):
        raw_data = server.recv(4096)

        if str(raw_data,encoding="ascii") == ".shutdown":
            break

        print('>> ' + str(raw_data))

    server.close()

if __name__ == "__main__":
    main()