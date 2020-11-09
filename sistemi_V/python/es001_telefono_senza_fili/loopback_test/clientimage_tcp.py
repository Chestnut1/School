import socket
import os

server_ip = "127.0.0.1"
port = 8000

def client():

    with open("img2.jpg",'rb') as f:

        print(os.listdir())
        input()
        c = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

        c.connect((server_ip,port))
        print(f"connected. sending img.png ...")

        k = 0
        data = f.read()
        while data:
            
            c.sendall(data)
            data = f.read()
            print(f"sending data {k}")
            k = k + 1
    
        print("image sent.")

        c.send("close".encode())

    c.close()
    

if __name__ == "__main__":
    client()