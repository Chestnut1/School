"""
Author: Bruno Luca
Date: 28-04-2020

This program create a client process that send an equation to a serever that compute it, and send back the solution
"""

import socket

server_ip = '79.31.222.112'
server_port = 6000

def main():
    client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)   #create socket with IPv4 datagrams, using UDP protocoll

    while(True):
        equation = input(">> ")     #take data from command line

        client.sendto(equation.encode(), (server_ip, server_port))  #send data to server process

        if(equation[0:] == "close()"):  #if data is close() then close the server
            break

        result = client.recv(4096)  #wait for the server to send back the solution

        print(">> " + result.decode()[0:])
    
    client.close()




if __name__ == "__main__":
    main()