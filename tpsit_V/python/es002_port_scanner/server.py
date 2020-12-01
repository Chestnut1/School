import socket

def main():
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    s.bind(("127.0.0.1"))

if __name__ == "__main__":
    main()