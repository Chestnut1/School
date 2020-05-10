"""
Author: Bruno Luca
Date: 09-05-2020

This program create a UDP server that draw client's turtle.Turtle()

msg recvfrom() be like:
    -foreward
    -backward
    -left
    -right
"""

import socket
import turtle
import keyboard

server_ip = '127.0.0.1'
server_port = 8500

shutDownMessage = 'close()'

def main():
    client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)   #create a server process with ipv4 frame, using UDP protocoll
    esc = False
    while(not esc):
        

        if keyboard.read_key() == "w":
            client.sendto("w".encode(),(server_ip,server_port))
        elif keyboard.read_key() == "a":
            client.sendto("a".encode(),(server_ip,server_port))
        elif keyboard.read_key() == "s":
            client.sendto("s".encode(),(server_ip,server_port))
        elif keyboard.read_key() == "d":
            client.sendto("d".encode(),(server_ip,server_port))
            
        








if __name__ == "__main__":
    main()