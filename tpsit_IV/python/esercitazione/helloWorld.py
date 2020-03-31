print("Hello World")

x = 2.0

y = "banane"

print(f"x = {x} {y}")

#questo è un commento

"""
commenti per documentare il programma, viene estratta automaticamente dai tool per estrarre la documentazione
:D
"""

x = "due"

print(f"x = {x} {y}")

#proviamo ora a fare dei cicli for, degli if ecc...

"""
:-> indica a python un blocco di istruzioni, comandato dall'indtazione
"""

for i in range(0,10):
    if(i%2==0):
        print(f"[{i}]->pari")
    else:
        print(f"[{i}]->dispari")