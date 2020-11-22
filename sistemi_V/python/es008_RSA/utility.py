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

def euclide(a,b):

    """
    a,b:        number to use
    
    returns:    MCD of a and b
    """

    if b > a:
        a,b = b,a

    while True:
        newa = a % b
        if newa == 0:
            return b
            break
        else:
            a = b
            b = newa

def generate_keys():
    """
    returns:    n:  p*q
                c:  MCD(0..m) == 1 
                p:  input 
                q:  input
                m:  mcm(p-1,q-1) 
                d:  ((c*d) % m) == 1
    """

    #INSERTING PRIME NUMBERS
    while True:
        p,q = input("Insert (P,Q)>> ").split(",")
        p = int(p)
        q = int(q)

        if is_prime(p) and is_prime(q) and p > 1 and q > 1:
            print("numbers ok")
            break
    
    #CALCULATING n & m
    n = p*q
    print(f"n = {n}")
    
    m = int(((p-1)*(q-1))/euclide(p-1,q-1))

    #CALCULATING c NUMBERS AND ASK USER TO CHOSE ONE
    c_list = []
    for i in range(2,m+1):
        if euclide(i,m) ==1:
            c_list.append(i)

    while True:
        c = int(input(f"Chose c {c_list}>>"))
        if c in c_list:
            break
    
    #CALCULATING d NUMBERS AND ASK USER TO CHOSE ONE
    d_list = []
    for i in range(1,m+1):
        if ((c*i) % m) == 1:
            d_list.append(i)
    
    while True:
        d = int(input(f"Chose d {d_list}>> "))
        if d in d_list:
            break
    return n, c, p, q, m, d