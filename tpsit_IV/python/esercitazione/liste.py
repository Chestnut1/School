#questa è una li
lista = [10,3,-4,6,5,123,32,136,435]

print(f"lista sliced {lista[1:3]}")

lista2 = lista[1:8:2]

print(f"lista 2 = {lista2}")

#aggiungo un elemento ad una lista con un metodo
l = [1,2,3]
l.append(4)
print(f"append = {l}")

#rimuovere un elemento
l.pop(2)
print(f"append = {l}")
l.pop()
print(f"append = {l}")

#conto quante volte un elemento compare in ua lista
numeri1 = l.count(1)
print(f"n.1 = {numeri1}")

#riodrino una lista
lista.sort()
print(f"lista ordinata = {lista}")
lista.reverse()
print(f"lista reverse = {lista}")

#copio una lista
l1 = [1,2,3]
l2 = l1
l1.append(999)
print(f"l2 = {l2}")     #così l2 punta a l1, quindi se voglio copiare una lista accio:

#metodo 1
l2 = l1[:]
#motodo 2
l2 = l1.copy()
l1.append(2)
print(f"l2 = {l2}      l1 = {l1}")


#NAN, un po' come l null in c

for i in range(0,3):
    print(f"i = {i}")

while():
    #break->esco dal ciclo
    #continue->salta un giro
    pass






