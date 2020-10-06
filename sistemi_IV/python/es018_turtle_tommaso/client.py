import socket

IpAddress = '192.169.88.89'
port = 8000

cli = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

while (True):

    # invio del messaggio
    msg = input("testo del messaggio:")
    cli.sendto(msg.encode(), (IpAddress, port))

cli.close()