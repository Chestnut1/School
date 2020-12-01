import socket
import config

server_ip = "127.0.0.1"
port = 9000

def server():
    file_name = "copy_image.png"

    s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    s.bind((server_ip,port))
    s.listen()
    conn,add = s.accept()
    print("client connected...")

    f = open(file_name, "wb")

    done = False
    c = 0

    line = conn.recv(config.BUFFER_SIZE)
    while line != config.END_IMG_STRING.encode():
        try:
            print(f"writing image{c}")

            f.write(line)
            c = c + 1
        except:
            print("cant write image")
        line = conn.recv(config.BUFFER_SIZE)

        

    print("image copied")

    f.close()
    s.close()

if __name__ == "__main__":
    server()