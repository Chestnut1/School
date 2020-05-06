"""
Author: Bruno Luca
Date: 06-05-2020

This program create a simple TCP-IP server that comunicate with a client
"""

import socket

server_ip = '127.0.0.1'
server_port = 8500

shutDownMessage = 'close()'

def main():
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)   #create socket with IPv4 datagrams, using TCP protocoll

    server.bind((server_ip, server_port))   #associate ip and port to the server process
    print(f"\nServer bind success! \n\nport: {server_port} ip: {server_ip}\n")

    server.listen()     #let the serevr listen for new connections
    connection, address = server.accept()

    while(1):
        raw_data = connection.recv(4096)

        if raw_data.decode() == shutDownMessage:
            break

        print(f"{address}>> say: {raw_data.decode()}... sending back same message...")

        connection.sendall(raw_data)

    server.close()


if __name__ == "__main__":
    main()