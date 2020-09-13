"""
Author: Bruno Luca
Date: 18-08-2020
Title: Scrivere una funziona di nome usa_solo che richeida una parola e 
una stringa di lettere e restituisca true se la parola contiene solo le lettere indicate.
"""

def usa_solo(word, letter_list):
    for letter in word:
        if not (letter in letter_list):
            return False
    return True 

fin = open("words.txt")

letters = input("Insert letters then press invio...")

for line in fin:
    if usa_solo(line.strip(), letters):
        print(line.strip())


