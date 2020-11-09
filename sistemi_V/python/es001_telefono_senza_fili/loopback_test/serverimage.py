import socket

server_ip = "127.0.0.1"
port = 8000

def server():
    file_name = "copy_image.jpg"

    s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    s.bind((server_ip,port))
    s.listen()
    conn,add = s.accept()
    print("client connected...")

    f = open(file_name, "wb")

    done = False
    c = 0
    while not done:
        line = conn.recv(40960000)

        try:
            if line.decode() == "exit":
                print("finished")
                done = True
        except:
            print(f"writing image{c}")

            f.write(line)

        c = c + 1

    print("image copied")

    f.close()
    s.close()

if __name__ == "__main__":
    server()