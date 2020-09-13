"""
Author: Bruno Luca
Date: 09-09-2020
"""

def fill_string(number, lenght):
    return str(number).zfill(lenght)

def palindrome(n):
    count = len(n)
    i = 0
    while count > 1:
        if n[i] != n[len(n)-(i+1)]:
            return False
        count = count -2
        i = i + 1
    return True

def main():
    for i in range(0,1000000):
        i = fill_string(i,6)
        if palindrome(i):
            print(i)

if __name__ == "__main__":
    main()