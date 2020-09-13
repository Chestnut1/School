"""
Author: Bruno Luca
Date: 11-09-2020
"""

def mediani(t):
    return t[1:len(t)-1]

def main():
    numbers = [1,2,3,4,5,6]
    print(mediani(numbers))

if __name__ == "__main__":
    main()