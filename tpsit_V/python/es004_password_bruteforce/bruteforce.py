"""
Author: Bruno Luca
Date: 29-01-2021
Es: create a tcp client that try entering a online login page
"""

import socket
import threading

server_ip = "127.0.0.1"
server_port = 5000

def client():
    c = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

    c.connect((server_ip,server_port))

    while True:
        msg = """POST http://127.0.0.1:5000/ HTTP/1.1
Host: http://127.0.0.1:5000
content_type= "application/x-www-form-urlencoded"
content_length= len(body)

usr=luca@mail.com&pwd=1234"""

        print(f"sending:\n\n{msg}\n\n")
        c.sendall(msg.encode())
        echo_msg = c.recv(4096)
        print(f"ECHO>> {echo_msg}")
        if msg == "close":
            break
    
    c.close()


if __name__ == "__main__":
    client()