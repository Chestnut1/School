"""

int n_biglietti = 100;

int filaA = 10;
int filaB = 6;

pthread_mutex_t m1 = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t m2 = PTHREAD_MUTEX_INITIALIZER;

void *cassa1(void *argv){
    int rnd, rndM;

    /* SEZIONE CRITICA */
    pthread_mutex_lock(&m1);
    filaA--;
    rnd = 1 + rand()%10;
    printf("Sono il cliente %u alla cassa 1 e voglio acquistare %d biglietti\n", pthread_self(), rnd);
    if(n_biglietti == 0){
        printf("Biglietti acquistati 0\n");
    }else if(n_biglietti>0 && rnd<=n_biglietti){
        printf("Biglietti acquistati %d\n", rnd);
        n_biglietti = n_biglietti - rnd;
    }else if(n_biglietti>0 && rnd>n_biglietti){ // maggiore dei biglietti disponibili
        printf("Biglietti acquistati %d\n", n_biglietti);
        n_biglietti = 0;
    }

    rndM = rand()%2;
    printf("Biglietti disponibili %d\nRAND %d\n", n_biglietti, rndM);
    if(rndM == 0){ // Prosegue cassa A
        if(filaA>0){ // se ancora clienti in coda
            pthread_mutex_unlock(&m1);
        }else{ // proseguo con fila B
            pthread_mutex_unlock(&m2);
        }
    }else{ // Prosegue cassa A
        if(filaB>0){ // se ancora clienti in coda
            pthread_mutex_unlock(&m2);
        }else{ // proseguo con fila A
            pthread_mutex_unlock(&m1);
        }
    }
    /* FINE SEZIONE CRITICA */
	pthread_exit(NULL);
}
"""

import random
import threading
import logging as log

CLIENTS = 10

tickets = 100

filaA = 6
filaB = 10

c1 = threading.lock()
c2 = threading.lock()

def cassa1(index):
    
    global filaA
    global tickets

    c1.acquire()
    filaA = filaA - 1

    rnd = random.randrange(1,10)
    log.info(f"I'm client {index} at 2 and want to buy {rnd} tickets")
    if tickets == 0:
        log.info("0 tickets bought")
    elif rnd < tickets:
        log.info(f"{rnd} tickets bought")
        tickets = tickets - rnd
    else:
        log.info(f"{tickets} tickets bought")
        tickets = 0

    log.info(f"REMAINING TICKETS = {tickets}")

    if random.randrange(0,10) % 2 == 0: #cassa 1
        if filaA > 0:   #check for remaining clients 
            c1.release()
        
        else:
            c2.release()
    else:   #cassa 2
        if filaB > 0:   #check for remaining clients 
            c2.release()
        else:
            c2.release()


def cassa2(index):
    
    global filaB
    global tickets

    c2.acquire()
    filaB = filaB - 1

    rnd = random.randrange(1,10)
    log.info(f"I'm client {index} at 2 and want to buy {rnd} tickets")
    if tickets == 0:
        log.info("0 tickets bought")
    elif rnd < tickets:
        log.info(f"{rnd} tickets bought")
        tickets = tickets - rnd
    else:
        log.info(f"{tickets} tickets bought")
        tickets = 0

    log.info(f"REMAINING TICKETS = {tickets}")

    if random.randrange(0,10) % 2 == 0: #cassa 2
        if filaB > 0:   #check for remaining clients 
            c2.release()      
        else:
            c1.release()
    else:   #cassa 1
        if filaA > 0:   #check for remaining clients 
            c1.release()
        else:
            c2.release()

def main():
    #configuring log message info
    format = "%(asctime)s: %(message)s"
    log.basicConfig(format = format, level = log.INFO, datefmt= "%H:%M:%S")

    log.info("CINEMA IS OPNE")

    log.info("Creating thrads")
    t1 = [threading.Thread(target= cassa1, args=(i+1,)) for i in range(0,CLIENTS)]
    t2 = [threading.Thread(target= cassa2, args=(i+1,)) for i in range(0,CLIENTS)]

    c1.release()
    c2.acquire()

    for i,_ in enumerate(t1):   #lauching threads
        t1[i].start()
        t2[i].start()

    for i,_ in enumerate(t1):   #waiting for thread to finish
        t1[i].join()
        t2[i].join()


if __name__ == "__main__":
    main()