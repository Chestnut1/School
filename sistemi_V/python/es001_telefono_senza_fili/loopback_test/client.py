import socket

server_ip = "127.0.0.1"
server_port = 7000


def client(msg = input("IMAGE FILENAME>> ")):

    with open(msg, "rb") as f:
        data = f.read()
    
    c = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    c.connect((server_ip,server_port))  

    c.sendall(data.encode())

    input("Data sent correctly. Press any key to close client process...")
    c.close()



if __name__ == "__main__":
    client()