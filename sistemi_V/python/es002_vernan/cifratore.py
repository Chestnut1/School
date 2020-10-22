"""
Author: Bruno Luca
Date: 15-10-2020
Programma che cifra un messaggio dato dall'utente con chiave inserita da tastiera usando un cifrario di Vernan
"""

number2char = {}
char2number = {}
for i in range (65,91):
    char2number[chr(i)] = i - 65
    number2char[i-65] = chr(i)

def cifratore(msg = input("MESSAGGIO>> "),chiave = input("CHIAVE>> ")):

    global number2char
    global char2number

    while len(msg) > len(chiave):
        print(f"key lenght must be at least {len(msg)}...\t current({len(chiave)})")
        chiave = input("CHIAVE>> ")

    msg = msg.upper()
    chiave = chiave.upper()

    cifred_msg = ""
    for i,c in enumerate(msg):
        print(chiave[i])
        if ord(c) in range(65,91):
            cifred_msg = cifred_msg + number2char[(char2number[c] + char2number[chiave[i]])%26]
        else:
            cifred_msg = cifred_msg + c

    decifratore(cifred_msg,chiave)


def decifratore(msg,chiave):

    global number2char
    global char2number

    print(f""" 
    cifratore has 
    msg = {msg}
    key = {chiave}
    """)

    dec_msg = ""
    for i,c in enumerate(msg):
        if ord(c) in range(65,91):
            dec_msg = dec_msg + number2char[(char2number[c] - char2number[chiave[i]])%26]
        else:
            dec_msg = dec_msg + c

    print(f"DECRIPTED MSG>> {dec_msg}")


if __name__ == "__main__":
    cifratore()