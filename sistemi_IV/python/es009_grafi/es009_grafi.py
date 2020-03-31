def orientedMatrix():
    nodes = int(input("Inserire numero di nodi: "))

    matrix = []

    for i in range(0,nodes):
        neighbor = [int(n) for n in input(f"Inserisci i nodi adiacenti a {i}: ").split(",")]
        column = [0 for n in range(0,nodes)]
        for n in neighbor:
            if(n != -1):
                column[n] = 1
        matrix.append(column)

    return matrix

def heavyOrientedMatrix():
    nodes = int(input("Inserire numero di nodi: "))

    matrix = []

    for i in range(0,nodes):
        heavy_neighbor = [n for n in input(f"Inserisci i nodi adiacenti a {i} con il peso (2|32,): ").split(",")]
        column = [0 for n in range(0,nodes)]

        neighboor=[]
        heavy=[]
            
        for k in heavy_neighbor:
            n,h = k.split("|")
            neighboor.append(int(n))
            heavy.append(int(h))
        print(neighboor,heavy,column)
        for p,n in enumerate(neighboor):
            column[n] = heavy[p]

        matrix.append(column)

    return matrix


    


def adj2dict(m):
    d = {}
    for n in range(0,len(m)):
        d[n] = m[n]
    return d

def dict2adj(d):
    m = []
    for _, e in d.items():
        m.append(e)
    return m

def main():
    """
    m = orientedMatrix()
    print(m)
    d = adj2dict(m)
    print(d)
    print(dict2adj(d))
    """
    heavy_m = heavyOrientedMatrix()
    print(heavy_m)

if __name__ == "__main__":
    main()