"""
Author: Bruno Luca
Date: 11-09-2020
"""

def ordinata(t):
    sorted_list = sorted(t)
    return sorted_list == t

def main():
    numbers = ['a','b','c','a']
    print(ordinata(numbers))

if __name__ == "__main__":
    main()