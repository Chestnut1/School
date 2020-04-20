#include<stdio.h>
#include<stdlib.h>
#include<semaphore.h>
#include<pthread.h>
#include<unistd.h>

sem_t s1,s2;

void *ping(void *arg){
    while(1){
        sem_wait(&s2);  //blocco semaforo funzione pong
        printf("Ping\n");
        sleep(1);
        sem_post(&s1);  //sblocco s1
    }
    pthread_exit(0);
}

void *pong(void *arg){
    while(1){
        sem_wait(&s1);
        printf("Pong\n");
        sleep(1);
        sem_post(&s2);
    }
    pthread_exit(0);
}

int main(int argc, char **argv){
    pthread_t t1,t2;

    //inizializzazione semafori
    sem_init(&s1, 0, 0);     //0-->ROSSO
    sem_init(&s2, 0, 2);     //1-->VERDE, se mettessi 2 dovrei usare il doppio delle lock

    pthread_create(&t1, NULL, ping, NULL);
    pthread_create(&t2, NULL, pong, NULL);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    return 0;
}