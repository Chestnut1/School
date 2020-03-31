import subprocess

while True:
    ip = input("Inserisci l'insirizzo ip: ").split(".")
    int_ip = [int(i) for i in ip]

    if(len(int_ip) == 4 and int_ip[0]<=255 and int_ip[0]>=0 and int_ip[1]<=255 and int_ip[1]>=0 and int_ip[2]<=255 and int_ip[2]>=0 and int_ip[3]<=255 and int_ip[3]>=0):
        break
    else:
        print("Invalid ip.")


while True:
    mask = int(input("Inserisic la maschera: "))
    subnet = int(input("Inserisci la subnet: "))
    if(mask<=32 and mask>=0and subnet<=32 and subnet>=0):
        break
    else:
        print("Invalid mask. ")

n_host = pow(2,(32-(mask+subnet)))-2

print(f"""
ip = {int_ip}
mask = {mask}
n_host = {n_host}
""")

bin_ip = [bin(i) for i in int_ip]

inc3 = 0
inc2 = 0        
inc1 = 0
inc0 = 0

for i in range (0,pow(2,(subnet))):
    print(f"|SUBNET {i}|")

    print(f"""network: {int_ip[0]+inc0}.{int_ip[1]+inc1}.{int_ip[2]+inc2}.{int_ip[3]+inc3}
host range:""")
    
    for k in range(1,n_host+1):
        if inc3 + int_ip[3]<255:
            inc3 = inc3 + 1
        else:
            inc3 = 0
            int_ip[3] = 0
            if inc2 + int_ip[2] < 255:
                inc2 = inc2 + 1
            else:
                inc2 = 0
                int_ip[2] = 0
                if inc3 + int_ip[1] < 255:
                    inc1 = inc1 + 1
                else:
                    inc1 = 0
                    int_ip[1] = 0
                    if inc0 + int_ip[0] < 255:
                        inc0 = inc0 + 1
                    else:
                        inc0 = 0
                        int_ip[0] = 0

        print(f"{int_ip[0]+inc0}.{int_ip[1]+inc1}.{int_ip[2]+inc2}.{int_ip[3]+inc3}")

    if inc3 + int_ip[3]<255:
        inc3 = inc3 + 1
    else:
        inc3 = 0
        int_ip[3] = 0
        if inc2 + int_ip[2] < 255:
            inc2 = inc2 + 1
        else:
            inc2 = 0
            int_ip[2] = 0
            if inc3 + int_ip[1] < 255:
                inc1 = inc1 + 1
            else:
                inc1 = 0
                int_ip[1] = 0
                if inc0 + int_ip[0] < 255:
                    inc0 = inc0 + 1
                else:
                    inc0 = 0
                    int_ip[0] = 0
    print(f"broadcast: {int_ip[0]+inc0}.{int_ip[1]+inc1}.{int_ip[2]+inc2}.{int_ip[3]+inc3}")

    if inc3 + int_ip[3]<255:
        inc3 = inc3 + 1
    else:
        inc3 = 0
        int_ip[3] = 0
        if inc2 + int_ip[2] < 255:
            inc2 = inc2 + 1
        else:
            inc2 = 0
            int_ip[2] = 0
            if inc3 + int_ip[1] < 255:
                inc1 = inc1 + 1
            else:
                inc1 = 0
                int_ip[1] = 0
                if inc0 + int_ip[0] < 255:
                    inc0 = inc0 + 1
                else:
                    inc0 = 0
                    int_ip[0] = 0

p = subprocess.Popen(['ping', 'google.com'], stdout=subprocess.PIPE)
ping = p.communicate()
print(ping[0].decode())      

print(f"numero di ping positivi = {ping[0].decode().count('Tempo approssimativo')}")


    

    



        