"""
Author: Agbonson Fabrizio, Bruno Luca
Date: 11-09-2020
Title: this program create a multithread server capable to comunicate simultaneously with more than 2 client
"""

import socket
import threading

server_ip = "127.0.0.1"
server_port = 5000

def thread_listen(c,address):
    while True:
        msg = c.recv(4096).decode()
        print(f"{address}>> {msg}")

        if msg == "quit":
            break
        elif msg == "shutdown_server":
            for _,value in server_table.items():
                value.close()
            server.close()
    
    del server_table[c]


server_table = dict()
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

def main():
    

    server.bind((server_ip,server_port))
    server.listen()

    while True:
        c,address = server.accept()
        server_table[address] = threading.Thread(target=thread_listen,args=(c,address))
        server_table[address].start()
    
    server.close()





if __name__ == "__main__":
    main()