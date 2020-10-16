import socket
import base64

server_ip = "192.168.43.202"
port = 7000

def client():
    file_name = "image.png"

    f = open(file_name)

    

    c = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

    c.connect((server_ip,port))

    
    with open(file_name, "rb") as f:

        c.sendall(f.read())

    c.close()
    f.close()

if __name__ == "__main__":
    client()