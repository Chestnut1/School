import socket
from pynput.keyboard import Key, Listener


server_ip="127.0.0.1"
server_port=10000

client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

def on_press(key):
    if key == Key.up:
        client.sendto("w".encode(),(server_ip,server_port))
    if key == Key.down:
        client.sendto("s".encode(),(server_ip,server_port))
    if key == Key.left:
        client.sendto("a".encode(),(server_ip,server_port))
    if key == Key.right:
        client.sendto("d".encode(),(server_ip,server_port))

def on_release(key):
    if key == Key.esc:
        client.sendto("esc".encode(),(server_ip,server_port))
        return False    #Stop listener


def main():
    with Listener(
        on_press=on_press,
        on_release=on_release) as listener:
            listener.join()

if __name__ == "__main__":
    main()