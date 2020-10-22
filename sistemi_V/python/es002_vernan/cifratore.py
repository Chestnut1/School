"""
Author: Bruno Luca
Date: 15-10-2020
Programma che cifra un messaggio con chiave ITISDELPOZZO
"""



def cifratore():

    chiave = input("CHIAVE>> ")
    msg = input("MESSAGGIO>> ")
    msg = msg.upper()
    chiave = chiave.upper()

    #print(msg)

    alfabeto = {}
    reverse_alfabeto = {}
    for i in range (65,91):
        alfabeto[chr(i)] = i - 65
        reverse_alfabeto[i-65] = chr(i)

    print(alfabeto)

    #msg = CIAO
    print(msg)

    coded_msg = []
    coded_chiave = []
    for c in msg:
        coded_msg.append(str(alfabeto[c]))    #MSG = 28014
    for c in chiave:
        coded_chiave.append(str(alfabeto[c]))

    print(coded_msg)
    print(coded_chiave)

    summed_msg = []
    offsets = []
    for i in range(0,len(coded_msg)):
        summed_msg.append(str((int(coded_chiave[i]) + int(coded_msg[i])) % 21))
        if (int(coded_chiave[i]) + int(coded_msg[i])) > 21:
            offsets.append(1)
        else:
            offsets.append(0)

    print(summed_msg)

    decifratore(summed_msg,chiave,offsets)


def decifratore(msg,chiave,offsets):

    alfabeto = {}
    reverse_alfabeto = {}
    for i in range (65,91):
        alfabeto[chr(i)] = i - 65
        reverse_alfabeto[i-65] = chr(i)

    print(f""" 
    cifratore has 
    msg = {msg}
    key = {chiave}
    offsets = {offsets}
    """)

    summed_msg = []

    for i,c in enumerate(msg):
        summed_msg.append(21 * offsets[i] + int(c))

    print(f"decripted summed msg>> {summed_msg}")
    
    coded_msg = []
    for i,c in enumerate(summed_msg):
        coded_msg.append(alfabeto[chiave[i]] - int(c))

    print(f"decripted coded msg>> {coded_msg}")
    
    msg = ""
    for c in coded_msg:
        if c < 0:
            print(-c)
            msg = msg + reverse_alfabeto[-c]
        else:
            msg = msg + reverse_alfabeto[c]

    
    print(f"decripted msg>> {msg}" )


if __name__ == "__main__":
    cifratore()