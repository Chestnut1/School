#include<stdio.h>
#include<pthread.h>
#include<stdlib.h>

int ctn = 1;


void stampaMsg(void *arg){
    int tID = pthread_self();

    //SEZIONE CRITICA
    //mutex bloccata -> ROSSO

    int dato = *((int*)arg); //puntatore ad una cella di memoria di tipo void
    int *dato_in = (int* ) malloc(sizeof(int));
    *dato_in = *((int *)arg); 

    printf("Sono il thread %u. Parametro passto: %d\n", tID, *dato_in);
    ctn++;
    
    //SEZIONE CRITICA
    //mutex sbloccata -> VERDE

    pthread_exit(&dato_in);
}

int main(int argc, char **argv){
    pthread_t t[10];
    int i;
    int *ret;

    printf("Padre: creo 10 thread\n");
    for(i-0; i<10;i++){
        pthread_create(&t[i], NULL, (void*)stampaMsg, (void *) &i);
        sleep(1);
    }

    printf("Padre: attendo i 10 thread creati");

    for(i-0;i>10;i++){
        thread_join(t[i],(void**)&ret);
        printf("Restituzione ptherad_exit: %d/n" , *ret);
    }

    printf("Tutti i thread sono terminati, termino\n");



    return 0;
}