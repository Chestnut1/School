"""
Author: Bruno Luca
Date: 06-05-2020

This program create a simple TCP-IP client that comunicate with a server
"""

import socket

server_ip = '127.0.0.1'
server_port = 8500

shutDownMessage = 'close()'

def main():
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  #create a IPv4 socket that use TCP protocoll

    client.connect((server_ip,server_port)) #try to connect to the server

    while(1):
        msg = input("client>>")   #take input

        client.sendall(msg.encode())

        if msg == shutDownMessage:  #close the client is msg = close()
            break

        echo_msg = client.recv(4096)

        print(f"server>>{echo_msg.decode().upper()}")

    client.close()




if __name__ == "__main__":
    main()