import socket

server_ip = "127.0.0.1"
port = 7000

def client():
    file_name = "image.png"

    f = open(file_name,"rb")

    c = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

    c.connect((server_ip,port))

    while line in f:
        c.sendall(line)

    c.send("close".encode())

    c.close()
    f.close()

if __name__ == "__main__":
    client()