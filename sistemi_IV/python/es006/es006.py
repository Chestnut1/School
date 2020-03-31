#guardare par 5.1.1 5.1.2 e implementare es 2 delle pile (parentesi)

import random


#WRAPPER
def push(stack,element):
    stack.append(element)
    return stack

def pop(stack):
    return stack, stack.pop()

casualList = [1,2,3,"CIAO "]
print(casualList)

casualList = push(casualList,"MONDO")
print(casualList)

casualList,_ = pop(casualList)
print(casualList)

#verifica
class carta(object):
    def __init__(self,numero,seme):
        self.seme = seme
        self.numero = numero

    def toString(self):
        print(f"|{self.numero}|{self.seme}|")
    
c = carta(10,"c")

c.toString()

mazzo = []
semi = ["c", "p" , "d" , "f"]

for i in range(0,14):
    for s in semi:
        push(mazzo,carta(s,i))

for k in mazzo:
    k.toString()