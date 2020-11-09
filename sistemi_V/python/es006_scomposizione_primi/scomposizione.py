"""
Author: Bruno Luca
Date: 09-11-2020
Title: Create a program that given a numke make its prime factorization
"""

import math

def is_prime(n):
    """
    n:          number to check
    
    returns:    -0: number not prime
                -1: number prime
    """

    #n is the prime number to find out
    bruteforce_numbers = []
    for i in range (2,int(math.sqrt(n) + 1)):
        bruteforce_numbers.append(i)
    
    for number in bruteforce_numbers:
        if n != number and n % number == 0:
            return 0

    return 1

def factorizer(n):
    """
    n:          number to factorize
    
    returns:    [list of its factor]
    """

    if is_prime(n):
        print("prime number")
        return [n]

    factors = []    #list of factors
    current = n

    for i in range(2,int(n/2)+1):
        flag = 1
        while flag:
            if (current % i) == 0:
                factors.append(i)
                current = current / i
            else:
                flag = 0

    return factors

def main():
    print(factorizer(63))

if __name__ == "__main__":
    main()