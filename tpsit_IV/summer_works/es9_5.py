"""
Author: Bruno Luca
Date: 18-08-2020
Title: Scrivere una funziona di nome usa_tutte che richieda una parola e 
una stringa di lettere richieste e che restituisca True se la parola utilizza 
tutte le lettere richeiste almeno una volta
"""

def usa_tutte(word, letter_list):
    for letter in letter_list:
        if not (letter in word):
            return False
    return True

letters = input("Insert letters...\n")
fin = open("words.txt")
counter = 0

for line in fin:
    if usa_tutte(line.strip(), letters):
        print(line.strip())
        counter = counter + 1

print(f"\n\n{counter}")     #598 words use all vocals


