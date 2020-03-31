#include<stdio.h>
#include<ptheread.h>

void *uno(void *arg){   //arg indirizzo parametro passato dal processo padre
    printf("Sono il thread che esegue la funzione uno()");
    //return;
    pthread_exit(0);    //puntaotre ad un'area di memoria
}

void due(void *arg){
    printf("Sono il thread che esefue la funzone due.");
    pthread_exit(0);
}

in main(int argc, char **argv){
    ptheread_t  t1,t2;    
    //gcc main.c -o es1 -lpthread
    //./es1

    printf("Padre: creo due thread\n");
    
    //funzione che crea un thread, 0 se a buon fine
    //(indirizzo variabile thread, attributi che si possono assegnare al processo durante la sua creazone (NULL per default), )
    pthread_create(&t1, NULL, (void *)uno, NULL);
    pthread_create(&t2, NULL, (void *)&due, NULL);

    printf("Padre: attendo la crazione dei thread creati.  \n");

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    printf("Padre: i thread sono stati termianti, chiudo applicazione/n");

    return 0;
}