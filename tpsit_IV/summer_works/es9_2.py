"""
Author: Bruno Luca
Date: 15-08-2020
Title: Modificare il programma del paragrafo precedente in modo che stampi 
solo le lettere dell'elencor prive della lettera 'e', e ne calcoli la precentuale sul totale.
"""

def niente_e(word):
    if "e" in word:
        return False
    else:
        return True

fin = open("words.txt")

counter = 0 
tot = 0

for line in fin:
    tot = tot + 1
    if (niente_e(line.strip())):
        print(line.strip())
        counter = counter + 1

fin = open("words.txt")
print(f"In fine 'words.txt' {(counter*100)/tot}% of words are without letter 'e'...")



