#scrivere un programma che riempa una lista arbitraria chiedendo i valori degli elementi all'untente
import math

lista = []
while(1):
    x = int(input("Inserisci un numero: "))
    if(math.isnan(x)):
        break
    else:
        lista.append(x)

print(f"Lista = {lista}")