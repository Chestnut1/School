import socket

server_ip = "192.168.0.120"
port = 7000

def client(msg = input("MSG>> ")):

    c = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)

    print(msg)
    #msg = "Error: Traceback send failed"
    c.sendto(msg.encode(),(server_ip,port))
    c.close()

if __name__ == "__main__":
    client()