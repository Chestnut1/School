def dict2adj(d):
    m = []
    for _, e in d.items():
        m.append(e)
    return m

from sys import argv

data = open(argv[1], 'r')
lines = data.readlines()

d = {}

for line in lines:
    row = line.split(" ")
    row = [int(e) for e in row]
    patient = row.pop(0)
    spreaded = [-1 for e in range(0,len(lines))]
    for r in row:
        spreaded[r] = r
    d[patient] = spreaded
    
matrix = dict2adj(d)

p0 = []
for l in range(0,len(matrix)):
    spread = False
    found = False
    zero = False
    for c in range(0,len(matrix)):
        if not spread and matrix[l][c] != -1:
            spread = True
    
    if spread:
        for k in range(0,len(matrix)):
            if not found and l != k and l in matrix[k]:
                found = True
            if k == (len(matrix)) -1 and not found:
                zero = True

    if zero:
        p0.append(l)

        
    



for k,v in d.items():
    print(f"[{k}] = {v}")

print(f"""
{matrix}

{p0}
""")



data.close()