"""
Author: Bruno Luca
Date: 11-09-2020
Title: istogramma con get 
"""

def istogramma(s):
    d = {}
    for c in s:
        d[c] = d.get(c,0) + 1

    return d

def main():
    h = istogramma("banana")
    print(h)

if __name__ == "__main__":
    main()