import socket
import turtle
import random

server_ip = '127.0.0.1'
server_port = 10000

main_turtle = turtle.Turtle()
main_turtle.hideturtle()

turtle_table = {}
connection_table = []

def forward(x,t):
    t.forward(x)
def backward(x,t):
    t.backward(x)
def left(x,t):
    t.left(x)
def right(x,t):
    t.right(x)


commands = {
    "w": forward,
    "a": left,
    "s": backward,
    "d": right,
}
command_list = [k for k,_ in commands.items()]
    



def main():
    server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    server.bind((server_ip, server_port))

    while True:
        command, address = server.recvfrom(4096)
        command = command.decode()[0:]

        print(address)
        print(connection_table)
        print(turtle_table)

        if address in connection_table:
            if command == "esc":
                turtle_table.pop(address)
                connection_table.pop(connection_table.index(address))
            elif command in command_list:
                commands[command](10,turtle_table[address])
        else:
            connection_table.append(address)
            turtle_table[address] = main_turtle.clone()
            turtle_table[address].showturtle()

if __name__ == "__main__":
    main()
