import socket
import os
import config 

server_ip = "127.0.0.1"
port = 9000

def client():

    with open("img.png",'rb') as f:

        print(os.listdir())
        input()
        c = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

        c.connect((server_ip,port))
        print(f"connected. sending img.png ...")

        k = 0
        data = f.read(config.BUFFER_SIZE)
        while data:
            
            c.sendall(data)
            data = f.read(config.BUFFER_SIZE)
            print(f"sending data {k}")
            k = k + 1
    
        print("image sent.")

        c.sendall()

    c.close()
    

if __name__ == "__main__":
    client()