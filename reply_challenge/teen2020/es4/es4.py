from sys import argv
import math
from itertools import permutations

combinations = []

data = open(argv[1] , "r")
lines = data.readlines()

for i in range(0,int(lines.pop(0))):
    how_many_g = int(lines.pop(0))
    king_string = lines.pop(0)
    gadgets = [lines.pop(0).rstrip("\n") for k in range(0,how_many_g)]


    suffixes = []

    for g in gadgets:
        suffixes.append(g)
        for k in range(1,len(g)):
            suffixes.append(g[k:])
    suff_in_string = []

    for index,s in enumerate(suffixes):
        if king_string.find(s) != -1:
            suff_in_string.append(s)

    print(suff_in_string)

    # for i in range(len(suff_in_string)):
    ok = False
    for i in range(len(suff_in_string)):
        perms = [''.join(el) for el in permutations(suff_in_string, i)]
        if king_string.strip() in perms:
            combinations.append(i)
            ok = True

    if not ok:
        combinations.append(-1)

data.close()

with open('output.txt', 'w') as out:
    for i, r in enumerate(combinations):
        out.write(f'Case #{i+1}: {r}\n')
        print(r)