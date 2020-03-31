#include<stdio.h>
#include<pthread.h>
#include<stdio.h>

pthread_muted_t m1, m2;  //mutex verde

void *ping(void *argv){
    while (true){
        //SEZIONE CRITICA
        ptherad_mutex_lock(&m1);
        sleep(1);   //rallento solamente per rendere piu' leggibile
        printf("ping\n");
        ptherad_mutex_unlock(&m2);
        //FINE SEZIONE CRITICA
    }
}

void *pong(void *argv){
    while (true){
        //SEZIONE CRITICA
        ptherad_mutex_lock(&m2);
        sleep(1);   //rallento solamente per rendere piu' leggibile
        printf("ping\n");
        ptherad_mutex_unlock(&m1);
        // FINE SEZIONE CRITICA
    }
}

int main(int argc, cahr **argv){
    pthread_t t1,t2;

    pthread_mutex_unlock(&m1);   //sblocchiamo la mutex -> VERDE
    pthread_mutex_lock(&m2);   //blocco la mutex -> ROSSO

    pthread_create(&t1, NULL, (void *ping()), NULL);
    pthread_create(&t2, NULL, (void *pong()), NULL);

    pthread_join(t1,NULL);
    pthread_join(t2,NULL);

    return 0;
}