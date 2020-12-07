"""
Author: Bruno Luca
Date: 4-12-2020
"""


import socket
import config
import random

def client():

    while True:
        N = int(input("Insert N (must be prime): "))
        if config.is_prime(N):
            break

    while True:
        g = random.randint(2,N-1)
        if input(f"g = {g}, want to keep it? (y/n)\n").upper() == 'Y':
            break

    
    a = int(input('Insert a: '))

    A = (g**a) % N

    print(f"""
    A = {A}
    a = {a}
    """)

    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client.connect((config.SERVER_IP,config.SERVER_PORT))

    client.sendall((f"{N},{g},{A}").encode())

    B = int(client.recv(4096).decode())

    b = (B**a) % N

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


    client.close()

if __name__ == "__main__":
    client()