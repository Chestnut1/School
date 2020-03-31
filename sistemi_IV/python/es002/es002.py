#scrivere un programma che chiede all'utente una lista di parole, poi chiede una lunghezza
#per poi produrre una lista di parole più lunghe di n

words = []
again = True

while(again):
    word = input("String (-1 to stop): ")
    if(word == "-1"):
        again = False
    else:
        words.append(word)

l = int(input("Insert lenght limit: "))

lista = []

for word in words:
    if((len(word) > l) and (word!="-1") ):
        lista.append(word)

print(words)







