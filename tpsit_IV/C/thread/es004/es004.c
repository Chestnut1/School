#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<time.h>
#include<unistd.h>

pthread_mutex_t m1 = PTHREAD_MUTEX_INITIALIZER;    //mutex inizializzata a verde
pthread_mutex_t m2 = PTHREAD_MUTEX_INITIALIZER;

void *ping(){
    while (1){
        //SEZIONE CRITICA
        
        pthread_mutex_lock(&m1);
        sleep(1);
        printf("ping\n");
        pthread_mutex_unlock(&m2);
    }
}

void *pong(){
    while (1){
        //SEZIONE CRITICA
        
        pthread_mutex_lock(&m2);
        sleep(1);
        printf("PONG\n");
        pthread_mutex_unlock(&m1);
    }
}

int main(int argc, char **argv){
    pthread_t t1,t2;

    pthread_mutex_unlock(&m1);   //sblocco la mutex
    pthread_mutex_lock(&m2);

    pthread_create(&t1, NULL, (void *)ping, NULL);
    pthread_create(&t2, NULL, (void *)pong, NULL);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    return 0;
}