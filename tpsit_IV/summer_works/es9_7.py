"""
Author: Bruno Luca
Date: 21-08-2020
Title: Scrivere un programma che trovi una parola con tre lettere doppie consecutive.
"""

def find_word(word):
    double = 0
    i = 0

    while i < len(word)-1:
        if word[i] == word[i+1]:
            double = double + 1
            i = i + 2
        else:
            i = i +1 - 2*double
            double = 0
            
    
        if double == 3 :
            return True
    
    return False
        


fin = open("words.txt")
counter = 0

for line in fin:
    word = line.strip()
    if len(word) >= 6:
        if  find_word(word):
            print(word)
            counter = counter + 1

print(f"\n{counter} word have triple double letters...\n")