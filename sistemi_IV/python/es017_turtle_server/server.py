import socket
import turtle

def main():
    turtle_main = turtle.Turtle()
    #turtle_main.forward(1000)

    server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

    server.bind(("127.0.0.1",5000))

    address_table = {}

    
    while True:
        """
        directon, address = server.recvfrom(4096)
        print(address)

        found = False
        for k,_ in address_table.items():
            if k == address[1]:
                found = True

        """




if __name__ == "__main__":
    main()