import socket
import turtle
import random

server_ip = '127.0.0.1'
server_port = 10000

main_turtle = turtle.Turtle()
main_turtle.hideturtle()

turtle_table = {}
port_table = []

def move(c, p):
    print(f"moving {p}")
    if c == "w":
        turtle_table[p].forward(10)
    elif c == "a":
        turtle_table[p].left(90)
    elif c == "s":
        turtle_table[p].backward(10)
    elif c == "d":
        turtle_table[p].right(90)



def main():
    server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    server.bind((server_ip, server_port))

    

    while True:
        command, address = server.recvfrom(4096)
        command = command.decode()[0:]

        print(address)
        print(port_table)
        print(turtle_table)

        if address[1] in port_table:
            if command == "esc":
                turtle_table.pop(address[1])
                port_table.pop(port_table.index(address[1]))
            else:
                move(command,address[1])
        else:
            port_table.append(address[1])
            turtle_table[address[1]] = main_turtle.clone()
            turtle_table[address[1]].showturtle()




    

if __name__ == "__main__":
    main()
