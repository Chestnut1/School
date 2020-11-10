"""
Author: Bruno Luca
Date: 10-11-2020
Title: euclide theoreme
"""

def euclide(a,b):
    if b > a:
        c = a
        a = b
        b = c

    while True:
        newa = a % b
        if newa == 0:
            return b
            break
        else:
            a = b
            b = newa

def main(a = int(input("A>> ")), b = int(input("B>> "))):
    
    print(euclide(a,b))
    

if __name__ == "__main__":
    main()