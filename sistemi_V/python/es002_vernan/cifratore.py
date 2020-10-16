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
        reverse_alfabeto[i] = chr(i)
    


    #print(alfabeto)
    #CIAO

    print(msg)

    coded_msg = ""
    coded_chiave = ""
    for c in msg:
        coded_msg = coded_msg + str(alfabeto[c])
    for c in chiave:
        coded_chiave = coded_chiave + str(alfabeto[c])

    print(coded_msg)

    summed_msg = ""
    for i in range(0,len(coded_msg)):
        summed_msg = summed_msg + str((int(coded_chiave[i]) + int(coded_msg[i])) % 21)

    print(summed_msg)
    
    cifred_msg = ""
    for i in range(0,len(summed_msg)):
        cifred_msg = cifred_msg + reverse_alfabeto[summed_msg[i]]

    print(cifred_msg)







    
    #print(coded_msg)





def decifratore(msg):
    pass




if __name__ == "__main__":
    cifratore()