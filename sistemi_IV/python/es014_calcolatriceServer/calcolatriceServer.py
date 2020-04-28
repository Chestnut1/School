"""
Author: Bruno Luca
Date: 28-04-2020

This program create a server process that recive an equation as string, compute it, ad return back the value
"""

import socket

server_ip = '127.0.0.1'
server_port = 5000

def main():
    server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)   #create socket with IPv4 datagrams, using UDP protocoll

    server.bind((server_ip, server_port))   #associate ip and port to the server process

    while(True):
        raw_data, address = server.recvfrom(4096)   #saving data and address 

        if(raw_data.decode()[1:] == "close()"): #if data is close() then close the server
            break

        equation = eval(raw_data.decode()[0:])  #compute the equation excluting initial 'b'

        print( str(address) + ">> " + raw_data.decode()[0:] + " = " + str(equation))    

        server.sendto(str(equation).encode(), address)  #send back the result of the equation

    
    server.close()




if __name__ == "__main__":
    main()