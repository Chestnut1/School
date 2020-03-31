#date due liste scelte dall'utente calcolar l'intersezione (elementi comuni)

list1 = ["ciao" , "mi" , "chiamo" , "luca"]
list2 = ["ciao" , "sono" , "luca"]

intersection = []

for i in list1:
    if i in list2:
        intersection.append(i)

print(intersection)


