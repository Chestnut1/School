import socket

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server.bind(('127.0.0.1',5000))

server.listen()

server.accept()

l = []

while True: 

    data,address = server.recvfrom(4096)

    l.append(int(data.decode()))

    print(l)







