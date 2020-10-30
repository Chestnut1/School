import socket

server_ip = "127.0.0.1"
port = 7000

def server():
    file_name = "image_copy.png"

    s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

    s.bind((server_ip,port))
    s.listen()
    conn,add = s.accept()

    f = open(file_name, "wb")

    while True:
        data = conn.recv(4096)

        with data.decode() as close:
            if close == "close":
                break

        f.write(data)

    f.close()
    s.close()

    

if __name__ == "__main__":
    server()