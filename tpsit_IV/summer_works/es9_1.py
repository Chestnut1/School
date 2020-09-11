"""
Author: Bruno Luca
Date: 15-08-2020
Title: Scrivere un programma che legga il file word.txt e stampi solo le parole 
composte da più di 20 caratter (spazi esclusi)
"""

fin = open("words.txt")

for line in fin:
    word = [line[i] for i in range(len(line.strip())) if line[i] != " "]
    if(len(word) > 20):
        print(word)
