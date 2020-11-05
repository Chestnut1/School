"""
Author: Bruno Luca
Date:02-11-2020
Title: create a program that finds out the index(n) prime number 
"""

def is_prime(n):

    """
    n:          number to check
    
    returns:    -0: number not prime
                -1: number prime
    """

    #n is the prime number to find out
    bruteforce_numbers = []
    for i in range (2,10):
        bruteforce_numbers.append(i)
    
    for number in bruteforce_numbers:
        if n != number and n % number == 0:
            return 0

    return 1

def find_number(n):
    """
    n:          nth prime number to find

    return:     nth:    if prime number found
                -1:     if prime number not found 
    """

    current = 2
    count = n
    while True:

        if is_prime(current):
            count = count -1
        if count == 0:
            return current

        current = current + 1

def main():
    #see if its a prime number or not
    while True:
        n = input("Insert number (\"exit\" to close the program)>> ")
        if n.lower() == "exit":
            break
        elif n.isdigit():
            print(find_number(int(n)))
        else:
            print("Invalid input.")
    

if __name__ == "__main__":
    main()