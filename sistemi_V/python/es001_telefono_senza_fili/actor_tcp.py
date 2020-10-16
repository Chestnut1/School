import socket

server_ip = "192.168.88.85" 
server_ip_personal = "192.168.88.72"
port = 7000

def client(data):
    c = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    c.connect((server_ip,port))

    print(data)
    #data = "Error: Traceback send failed"
    c.sendall(data.encode())
    c.close()

def server():
    s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

    s.bind((server_ip_personal,port))
    s.listen()
    c,address = s.accept()

    raw_data = s.recv(4096)

    s.close()

    client(raw_data.decode())



if __name__ == "__main__":
    server()