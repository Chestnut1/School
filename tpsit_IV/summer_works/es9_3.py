"""
Author: Bruno Luca
Date: 15-08-2020
Title: Scrivere una funzione di nome evita che richieda una parola e una stringa 
di lettere vietate, e restituisca True se la parola non contiene alcuna lettera vietata. 

Modificare il programma in modo tale che richieda all'utente una stringa di lettere vietate, 
e poi stampi il numero di parole che non ne contengano alcuna. 
Riuscite a trovare una combinazione di 5 lettere vietate che ne escluda il più piccolo numero?
"""

def evita(word, l):
    for banned in l:
        if banned in word:
            return False
    return True

banned_letters = input("Insert all banned letters then press Enter...\n")

fin = open("words.txt")
counter = 0

for line in fin:
    if evita(line.strip(), banned_letters):
        counter = counter + 1

print(f"In file 'words.txt' there are {counter} words without {banned_letters}...")
