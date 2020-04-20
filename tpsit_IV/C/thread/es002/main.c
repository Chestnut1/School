#include<stdlib.h>
#include<stdio.h>
#include<pthread.h>
#include<time.h>

int ctn = 1;

void *stampaMsg(void *arg){
    int tID = pthread_self();   //mi restituisce un long int contentente l'identificativo del thread
    //int dato = *((int*)arg);

    //INIZIO SEZIONE CRITICA
    mute
    int *dato_din = (int*) malloc(sizeof(int));
    *dato_din = *((int *) arg);

    //printf("Sono il thread %u. Parametro: %d\n" , tID, dato);
    //printf("Sono il thread %u. Parametro: %d\n" , tID, *dato_din);

    printf("Sno il thread %u. Contatore: %d\n", tID, ctn);
    ctn++;

    //FINE SEZIONE CRITICA
    pthread_exit(&dato_din);
}

int main(int argc, char **argv){
    pthread_t t[10];
    int i;  //index
    int *ret;


    printf("Padre: creo 10 thread.\n");

    //creo 10 thread
    for(i=0; i<10; i++){
        pthread_create(&t[i], NULL, (void*)&stampaMsg, &i);
        sleep(1);
    }

    printf("Padre: attendo i 10 thread creati...\n");

    for(i=0; i<10;i++){
        pthread_join(t[i], (void**)&ret);
        printf("Restituzione pthred exit: %d\n" , *ret);
    }

    printf("Padre: tutti i thread sono stati terminati. Chiudo applicazione...\n");

    return 0;
}