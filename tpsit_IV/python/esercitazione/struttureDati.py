"""
in python esistono strutture dati complicate, ad esempio le liste,
 che sono implementazioni native delle liste che permettono di inserire più dati assieme
"""

def somma(a,b):
    return a+b


lista = [1, "ciao" ,3, somma(3,4) , somma]

print(f"lista = {lista}")

for i in lista:
    print(i)

print(f"somma = {somma(10,3)}")

posizione = 1

print(lista[posizione])

print(lista[-2])

print(lista[1:3])
print(lista[0:4])
print(lista[2:4])
print(lista[3:])

print(len(lista))