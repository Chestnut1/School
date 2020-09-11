"""
Author: Bruno Luca
Date: 10-09-2020

"""

def somma_cumulata(t):
    somma_cumulata = t[:]
    
    for i in range(len(t)):
        somma_cumulata[i] = sum(t[0:i+1])

    return somma_cumulata


def main():
    lists = [1,2,3,4,5]

    print(somma_cumulata(lists))

if __name__ == "__main__":
    main()