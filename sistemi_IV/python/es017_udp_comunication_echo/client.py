import socket

def main():
    server_ip = "192.168.88.89"
    server_port = 6000

    client = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)

    while True:

        msg = input(">> ")

        client.sendto(msg.encode(),(server_ip,server_port))

        result = client.recv(4096)

        print(f">> {result}")



if __name__ == "__main__":
    main()