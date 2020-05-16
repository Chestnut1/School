"""
Author: BRuno Luca
Date: 16-05-2020"
This program create a UDP serevr process that receive a message ("w", "a" , "s" , "d"). The message is passed to a dictionary of cammands that compute it and make 
the turle move.
"""

import socket
import turtle
import random

server_ip = '127.0.0.1'
server_port = 10000

main_turtle = turtle.Turtle()   #creating a main turtle and hiding it
main_turtle.hideturtle()

turtle_table = {}   #a turtle storage costruct {(client_ip, "client_port"): turtle.Turtle(), ...}
connection_table = []   #a connection storage construct connection_table[0] = (client_ip, "client_port")

#defining command function
def forward(x,t):
    t.forward(x)
def backward(x,t):
    t.backward(x)
def left(x,t):
    t.left(x)
def right(x,t):
    t.right(x)

#a commands dictionary for computing command received from client
commands = {
    "w": forward,
    "a": left,
    "s": backward,
    "d": right,
}
command_list = [k for k,_ in commands.items()]  #set a lsit of available command, to error prevent
    



def main():
    server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)   #creating UDP server with IPv4 datagrams 
    server.bind((server_ip, server_port))

    while True:
        command, address = server.recvfrom(4096)    #storing command send and address of client
        command = command.decode()[0:]

        print(address)
        print(connection_table)
        print(turtle_table)

        if address in connection_table: #check for the sending address in the address table
            if command == "esc":    #delete the turtle
                turtle_table.pop(address)
                connection_table.pop(connection_table.index(address))
            elif command in command_list:   #check if command received is in command table
                commands[command](10,turtle_table[address])
        else:   #creating new turtle and adding it to the turtle table
            connection_table.append(address)
            turtle_table[address] = main_turtle.clone()
            turtle_table[address].showturtle()

if __name__ == "__main__":
    main()
