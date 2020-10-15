import socket

server_ip = "192.168.88.85" 
server_ip_personal = "192.168.88.72"
port = 7000

def client(data):
    c = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)

    print(data)
    #data = "Error: Traceback send failed"
    c.sendto(data.encode(),(server_ip,port))
    c.close()

def server():
    s = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)

    s.bind((server_ip_personal,port))

    raw_data,address = s.recvfrom(4096)

    s.close()

    client(raw_data.decode())



if __name__ == "__main__":
    server()