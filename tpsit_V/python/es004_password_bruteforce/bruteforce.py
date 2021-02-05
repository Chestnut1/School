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

    with open("password_list.txt") as fin:

        username = input("USERNAME>> ")
        
        for password in fin:

            
            body = f"usr={username}&pwd=1234"

            
            msg = f"POST http://127.0.0.1:5000 HTTP/1.1\r\nHost: localhost:5000\r\nConnection: open\r\nContent_Type= 'application/x-www-form-urlencoded'\nContent_Length= {len(body)}\r\n\r\n"+body
            print(f"sending:\n\n{msg}\n\n")
            c.sendall(msg.encode())

            while True:
                echo_msg = c.recv(4096).decode()
                #echo_msg = echo_msg.split(" ")
                
                print(f"ECHO>> {echo_msg}")

            """     RIGHT PASSWORD

            ECHO>> HTTP/1.0 308 PERMANENT REDIRECT

            ECHO>> Content-Type: text/html; charset=utf-8
            Content-Length: 251
            Location: http://127.0.0.1:5000/
            Server: Werkzeug/1.0.1 Python/3.9.1
            Date: Thu, 04 Feb 2021 20:15:24 GMT

            <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
            <title>Redirecting...</title>
            <h1>Redirecting...</h1>
            <p>You should be redirected automatically to target URL: <a href="http://127.0.0.1:5000/">http://127.0.0.1:5000/</a>.  If not click the link.

            """

            """     WRONG PASSWORD

            ECHO>> HTTP/1.0 308 PERMANENT REDIRECT

            ECHO>> Content-Type: text/html; charset=utf-8
            Content-Length: 251
            Location: http://127.0.0.1:5000/
            Server: Werkzeug/1.0.1 Python/3.9.1
            Date: Thu, 04 Feb 2021 20:14:06 GMT

            <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
            <title>Redirecting...</title>
            <h1>Redirecting...</h1>
            <p>You should be redirected automatically to target URL: <a href="http://127.0.0.1:5000/">http://127.0.0.1:5000/</a>.  If not click the link.

            """

            
            
    
    c.close()


if __name__ == "__main__":
    client()