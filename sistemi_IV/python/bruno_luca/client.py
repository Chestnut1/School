"""
Author: Bruno Luca
Date: 16-05-2020
This program create a UDP socket process that send to the serevr some commands based on key pressed. Here a lsit of commands:

-ARROW UP:   send a "w" message that launch a .forward() function on the turtle
-ARROW LEFT: send a "a" message that launch a .left() function on the turtle
-ARROW RIGHT:send a "d" message that launch a .right() function on the turtle
-ARROW DOWN: send a "s" message that launch a .backward() function on the turtle
-ESC:        send a "esc" message that remove the created turtle and stop the client
"""

import socket
from pynput.keyboard import Key, Listener


server_ip="127.0.0.1"
server_port=10000

client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

def on_press(key):  #send command based on key pressed
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
    #launching on press and on release listeners
    with Listener(
        on_press=on_press,
        on_release=on_release) as listener:
            listener.join() 

if __name__ == "__main__":
    main()