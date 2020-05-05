import socket

with socket.socket(socket.AF_INET,socket.SOCK_DGRAM) as s:
    stringa = "hello mother fucker bitch"
    s.sendto(stringa.encode("ascii"), ("5.102.0.11", 5200))
    dati = s.recv(8192)
    print("eco del messaggio dal server: " + dati.decode("ascii"))



