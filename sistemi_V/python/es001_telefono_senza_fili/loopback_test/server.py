import socket
import os
import io
from PIL import Image

from array import array


server_ip = "127.0.0.1"
server_port = 7000

def server():
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind((server_ip, server_port))
    s.listen()

    print("Server is listening for new connections...")

    conn, add = s.accept()

    data = conn.recv(4096)

    print(f"{add}>> Image sent. Check the folder for the final file...")

    image = Image.open(io.BytesIO(bytearray(data.decode())))
    image.save("copied_image.JPG") 

    input("Press any key to close the server...")
    s.close()

if __name__ == "__main__":
    server()