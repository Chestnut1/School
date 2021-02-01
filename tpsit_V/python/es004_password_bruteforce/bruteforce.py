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
        """
        POST /auth HTTP/1.1\r\n
        Content-Type: application/x-www-form-urlencoded\r\n
        Content-Length: 29\r\n
        Host: localhost:9000\r\n
        Connection: close\r\n
        \r\n
        userName=Ganesh&password=pass
        """

        body = "usr=luca@mail.com&pwd=4"
        msg = f"POST http://127.0.0.1:5000 HTTP/1.1\r\nHost: localhost:5000\r\nConnection: open\r\nContent_Type= 'application/x-www-form-urlencoded'\nContent_Length= {len(body)}\r\n\r\n"+body
        print(f"sending:\n\n{msg}\n\n")
        c.sendall(msg.encode())
        echo_msg = c.recv(4096)
        print(f"ECHO>> {echo_msg}")
        if len(echo_msg) > 0:
            break
    
    c.close()


if __name__ == "__main__":
    client()