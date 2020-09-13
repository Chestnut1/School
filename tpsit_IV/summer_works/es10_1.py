"""
Author: Bruno Luca
Date: 10-09-2020

"""

def somma(t):
    somma = 0
    somma_nidificata = 0
    for element in t:
        for number in element:
            somma += number
        somma_nidificata += somma
        somma = 0
    return somma_nidificata

def main():
    lists = [[1,2,3] , [4,5,6] , [5,4,3]]

    print(somma(lists))

if __name__ == "__main__":
    main()