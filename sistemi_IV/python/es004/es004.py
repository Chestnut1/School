#Sorteggiatore di alunni per l'interrogazione
# 
#

import random as rnd

notSorted = ["Luca Bruno" , "Giavelli Luca" , "Tutti Gli Altri"]
sorted = []

for num, student in enumerate(notSorted):
    print(f"{num} - {student}")

print(f"viene interrogato : {notSorted[rnd.randint(0,len(notSorted)-1)]}")



