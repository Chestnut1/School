#include<stdio.h>
#include<stdlib.h>
#include<semaphore.h>
#include<pthread.h>
#include<unistd.h>

#define N 5
#define PENSA 2
#define HAFAME 1
#define MANGIA 0

sem_t mutex;
sem_t S[N];


int fil[N] = {1,2,3,4,5};

void *filosofo(void *num){
    while (1){  
        int *i = num;
        sleep(1);
    }
}

int main(int argc, char **argv){
    int i;
    pthread_t t[5];

    for(i=0; i<N; i++){
        pthread_create(&t[i], NULL, filosofo, &fil[i]);
        printf("Il filosofo %d sta pensadno...\n" , i+1);
    }

    for(i=0; i<N; i++){
        pthread_join(t[i], NULL);
        printf("Il filosofo %d sta pensadno...\n");
    }

    return 0;
}