import random

def push(stack,element):
    stack.append(element)
    return stack

def pop(stack):
    return stack, stack.pop()

def  mix(stack):
    for _ in range(0,100000):
        coppa = random.randint(1,52)
        stack1 = stack[coppa:] + stack[0:coppa]
    return stack1

class carta(object):
    def __init__(self,numero,seme):
        self.seme = seme
        self.numero = numero

    def toString(self):
        print(f"|{self.numero}|{self.seme}|")

mazzo = []

Semi = ["C" , "P" , "D" , "F"]

for i in range (1,14):
    for s in Semi:
        push(mazzo, carta(i,s))

coppa = random.randint(1,52)
mazzo1 = mazzo[coppa:] + mazzo[0:coppa]

print(f"Coppato in posizione |{coppa}|")

mazzo1 = mix(mazzo)

print(f"Mazzo mescolato:")

for c in mazzo1:
    c.toString()