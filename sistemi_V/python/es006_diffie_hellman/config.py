SERVER_IP = "127.0.0.1"
SERVER_PORT = 5000

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