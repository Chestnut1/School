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
    n = len(m)
    prev_popped = source_node
    successor = [i for i in range(0,n)]
    copy_successor = [s for s in successor]
    dist = [np.inf for _ in range(0,n)]
    dist[source_node] = 0
    prev = [-1 for _ in range(0,n)]

    choosen_successor = source_node
    print(f"Successor indexes: {copy_successor}")
    counter = 0
    while len(successor) > 0:
        print(f"""Passo: {counter}
        Successori: {successor}
        Distanze: {dist}
        Predecec: {prev}
        """)
        minlabel = np.inf
        #print("SUCCESSOR")
        for s in successor:
            #print(s)
            if dist[s] <= minlabel:
                minlabel = dist[s]
                choosen_successor = s
        print(f"Choosen successor: {choosen_successor}")
        print(f"Prev popped: {prev_popped}")
        
        
        prev[choosen_successor] = prev_popped
        prev_popped = successor.pop(successor.index(choosen_successor))
        

        #prev.append(successor.pop(successor.index(choosen_successor)))
        for node,weight in enumerate(m[choosen_successor]):
            if (dist[choosen_successor] + weight <  dist[node]) and (weight > 0):
                dist[node] = dist[choosen_successor] + weight
        counter = counter + 1
    
    return dist,prev

def getAdj(matrix):
    number_of_nodes = 0
    for i in range(0,len(matrix)):
        for e in range(0,len(matrix)):
            if matrix[i][e]:
                matrix[i][e] = number_of_nodes
                number_of_nodes = number_of_nodes + 1
            else:
                matrix[i][e] = -1
    returning_m = [[-1 for _ in range(0,number_of_nodes)] for _ in range(0,number_of_nodes)]

    current_node = 0            

    for counter_r,r in enumerate(matrix):
        for counter_c,c in enumerate(r):
            if c > -1:
                print(f"r = {counter_r}")
                print(f"c = {c}")
                print(f"current = {current_node}")
                if(counter_r - 1 >= 0) and (matrix[counter_r-1][counter_c]>=0):
                    returning_m[matrix[counter_r -1][counter_c]][current_node] = 1
                if(counter_r + 1 < len(matrix)) and (matrix[counter_r+1][counter_c]>=0):
                    returning_m[matrix[counter_r +1][counter_c]][current_node] = 1
                if(counter_c - 1 >= 0) and (matrix[counter_r][counter_c-1]>=0):
                    returning_m[matrix[counter_r][counter_c-1]][current_node] = 1
                if(counter_c + 1 < len(matrix)) and (matrix[counter_r][counter_c+1]>=0):
                    returning_m[matrix[counter_r][counter_c+1]][current_node] = 1
                current_node = current_node + 1

    return returning_m,number_of_nodes    
    

def main():

    grid = [[True, True, True, True, True, False],
            [False, False, True, True, True, False],
            [True, True, True, False, True, True],
            [True, False, False, True, True, False],
            [True, True, True, True, False, True],
            [True, False, True, True, True, False]]

    matrix,prev = getAdj(grid)
    
    dist,prev = djikstra(matrix,0)
    print(f"distanze: {dist}")
    print(f"predeces: {prev}")

if __name__ == "__main__":
    main()
