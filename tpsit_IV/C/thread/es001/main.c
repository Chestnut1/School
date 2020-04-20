#include<stdio.h>
#include<pthread.h>

void *uno(void *arg){
    printf("Sono il thread che esegue la funzione 1\n");

    pthread_exit(0); //puntatore in cui ci sara' il valore 0 in questo caso
}

void due(void *arg){
    printf("Sono il thread che esefue la funzione 2\n");

    pthread_exit(0);
}

int main(int argc, char **argv){
    pthread_t t1,t2;

    printf("Padre: creo due thread.\n");

    //funzione di creazione di un thread
    pthread_create(&t1, NULL, (void *)uno, NULL);
    pthread_create(&t2, NULL, (void *)&due, NULL);

    printf("Padre: attendo la creazione dei thread creati...\n");
    
    //funzione che attende la terminazione dei thread
    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    printf("Padre: i thread sono terminati. Chiudo applicazione...  \n");

    return 0;
}