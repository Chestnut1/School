import socket

server_ip = "192.168.0.120"
port = 7000

def client(msg = input("MSG>> ")):

    c = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    c.connect((server_ip,port))
    print(msg)
    #msg = "Error: Traceback send failed"
    c.sendall(msg.encode())
    c.close()

if __name__ == "__main__":
    client()