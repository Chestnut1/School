import socket


server_ip="127.0.0.1"
server_port=10000

client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)


def main():
    while True:
        msg = input(">>")
        client.sendto(msg.encode(), (server_ip,server_port))

if __name__ == "__main__":
    main()