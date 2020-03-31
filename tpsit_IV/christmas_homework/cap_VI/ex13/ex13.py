#let's wrtie a program similar to the upper one, but with argv and input
from sys import argv
script, name, surname = argv

print(f"Hi {name} {surname}! How old are you?", end = ' ')
age = input()
print(f"Ok {name}! I will remember it next time! ;)")

