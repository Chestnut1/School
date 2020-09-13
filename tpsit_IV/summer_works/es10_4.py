"""
Author: Bruno Luca
Date: 11-09-2020
"""

def tronca(t):
    del t[0]
    del t[len(t)-1]

def main():
    numbers = [1,2,3,4,5,6]
    tronca(numbers)
    print(numbers)


if __name__ == "__main__":
    main()