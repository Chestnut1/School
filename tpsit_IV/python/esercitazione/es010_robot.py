def dict2adj(d):
    m = []
    l = [False for i in range(0,len(d))]
    for k, e in d.items():
        for i in e:
            l[i-1] = 1
        m.append(l)
    return m


def matrix2dict(matrix):

    print(matrix)

    d = {}
    offset = 1
    number_of_nodes= 1
    links =[]

    for r in range(0,len(matrix)):
        print(f"r ={r}")
        for e in range(0,len(matrix)):
            links= []
            #print(f" i = {i} e = {e} len = {len(matrix)}")
            if matrix[r][e]!= False:
                #print(f"[{i}][{e}] libero")
                if r-offset >= 0:
                    if(matrix[r-offset][e]!=False):
                        links.append(matrix[r-offset][e])

                if e-offset >= 0:
                    if(matrix[r][e-offset]!=False):
                        links.append(matrix[r][e-offset])

                if e+offset < len(matrix):
                    if(matrix[r][e+offset]!=False):
                        links.append(matrix[r][e+offset])

                if r+offset < len(matrix):
                    if(matrix[r+offset][e]!=False):
                        links.append(matrix[r+offset][e])

                d[number_of_nodes] = links
                number_of_nodes =number_of_nodes+1
                print(links)
    
    return d

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

    matrix, nodes = getAdj(grid)
    print(matrix)

if __name__ == "__main__":
    main()