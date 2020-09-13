"""
Author: Bruno Luca
Date: 18-08-2020
Title: Scrivere una funziona di nome alfabetica che restituisca true se le lettere di una parola 
sono scrittte in ordine alfabetico (le doppie valgono)
"""

def alfabetica(word):
    sorted_word = "".join(sorted(word))
    if sorted_word == word:
        return True
    else:
        return False




fin = open("words.txt")
counter = 0

for line in fin:
    if alfabetica(line.strip()):
        print(line.strip())
        counter = counter + 1

print(f"\n{counter} words are sorted") 

