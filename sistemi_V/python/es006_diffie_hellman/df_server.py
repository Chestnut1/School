"""
Author: Bruno Luca
Date: 4-12-2020
"""

import socket
import config
import random

def server():
    server = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

    server.bind((config.SERVER_IP, config.SERVER_PORT))

    server.listen()

    conn,add = server.accept()

    data = conn.recv(4096)

    N,g,A = data.decode().split(',')

    N = int(N)
    g = int(g)
    A = int(A)

    print(f"""
    
        N = {N}

        g = {g}

        A = {A}

    """)


    b = int(input("Insert b: "))
    B = (g**b) % N

    conn.sendall(str(B).encode())

    a = (A**b) % N

    print(f"""
    RECAP--------------------

    N = {N}

    g = {g}

    A = {A}

    a = {a}

    B = {B}

    b = {b}

    -------------------------
    """)


    server.close()



if __name__ == "__main__":
    server()