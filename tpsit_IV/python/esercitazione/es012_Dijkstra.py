import numpy as np

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

def djikstra(m,source_node):
    unused_nodes = []
    returning_dist = []
    prev = []
    for node,l in enumerate(m):
        unused_nodes.append(node)
        prev.append(None)
    dist = [np.inf for _ in unused_nodes] #set every distance to maximum
    dist[source_node] = 0   #set source distance to 0

    while len(unused_nodes) > 0:
        nearest = unused_nodes[dist.index(min(dist))]   #return the nearest node in unused_node list
        unused_nodes.pop(unused_nodes.index(nearest))
        #print(nearest)
        #print(unused_nodes)
        
        neighbors = [index for index,e in enumerate(m[nearest]) if e==1]
        #print(neighbors)
        
        for n in neighbors:
            alt = dist[nearest] + m[nearest][n]
            if alt < dist[n]:
                dist[n] = alt
                prev[n] = nearest
        
        returning_dist.append(dist.pop(dist.index(min(dist))))
        #print(returning_dist)
        #print(prev)
    
    return returning_dist, prev

def main():
    matrix = orientedMatrix()
    print(matrix)
    dist,prev = djikstra(matrix,1)
    print(f"dist = {dist} prev = {prev}")


if __name__ == "__main__":
    main()
