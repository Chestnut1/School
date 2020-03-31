import math

graph = [[0,1,4,0,0,0,0,0],
         [1,0,0,0,0,2,0,0],
         [4,0,0,5,0,0,0,0],
         [0,0,5,0,1,3,0,0],
         [0,0,0,1,0,0,2,3],
         [0,2,0,3,0,0,0,0],
         [0,0,0,0,2,0,0,4],
         [0,0,0,0,3,0,4,0]]

labelList = [math.inf] * len(graph) #inizializzazione delle label (moltiplico per il numero di nodi per le righe)
labelList[0] = 0                    #distanza dal nodo sorgente = 0

unexploredNode = [0,1,2,3,4,5,6,7]   #nodi da esplorare

cntPasso=0

while len(unexploredNode)>0:
    print("Passo numero: %d"% cntPasso)
    print("Nodi inesplorati: ", unexploredNode)
    print("Lista delle label: ", labelList)
    print("-----------------------------------------------")
    #scelgo il nodo con label minore(k)
    infiniteList = [math.inf] * len(graph)
    
    for i in unexploredNode:
        infiniteList[i]=labelList[i]    #valore della labelList[i] 
    
    minimun = min(infiniteList)   #trovo il minimo

    if(minimun==math.inf):  #controllo per uscire dal ciclo
        break
    
    currentNode = infiniteList.index(minimun)  #prendo l'indice del valore minimo
    for node, weight in enumerate(graph[currentNode]):       #ciclo for con ricerca dei nodi collegati a k per indici non ancora esplorati
        if(weight!=0):   #verifico che sia collegato e che non sia se stesso
            newLabel = labelList[currentNode] + weight
            if(newLabel<labelList[node]):
               labelList[node] = newLabel     #per ogni nuovo nodo sommo (valore label(k)+peso arco di quel nodo) il valore della sua label e controllo se sono minori così sostituisco sennò niente
    
    cntPasso=cntPasso+1
unexploredNode.remove(currentNode) #rimuovo l'indice visitato 