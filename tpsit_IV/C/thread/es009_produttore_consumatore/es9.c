/**
 * Author: Bruno Luca
 * Date: 29-04-2020
 * Esercizio: abbiamo a disposizione dal programma un buffer condiviso da piu' thread  che va smaltito poco per volta. Due thread, un produttore e un consumatore.
 * Produttore> produce contenuto nel buffer
 * Cosnumatore> legge dal buffer
 **/

#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>
#include<semaphore.h>

#define MAXCICLI 100
#define DIM 10

sem_t mutex, pieno, vuoto;

char buffer[DIM];
int in, out;    //memorizzano la condizione iniziale

void *produci(void *arg){   
    int i = 0;
    char c;

    while (i < MAXCICLI){
        i++;

        c = (char) (rand()%26) + 97;

        sem_wait(&vuoto);   //per 10 iterazioni lascio passare
        sem_wait(&mutex);       //INIZIO SEZIONE CRITICA
        buffer[in] = c;
        printf("Inserito %c\n" , c);

        in = (in + 1 ) % 10;

        sem_post(&mutex);       //FINE SEZIONE CRITICA
        sem_post(&pieno);
    }
}

void *consuma(void *arg){   
    int i = 0;
    char c;

    while (i < MAXCICLI){
        i++;

        sem_wait(&pieno);
        sem_wait(&mutex);//INIZIO SEZIONE CRITICA
        
        c = buffer[out];
        printf("Prelevo %c \n" , c);
        out = (out + 1) % DIM;
        
        sem_post(&mutex);//FINE SEZIONE CRITICA
        sem_post(&vuoto);
    }
}

int main(int argc, char **argv){
    pthread_t prod, cons;

    //inizializzazione dei semafori
    sem_init(&mutex, 0, 1); //sbloccata
    sem_init(&pieno, 0, 0); //bloccato
    sem_init(&vuoto, 0, DIM);   //sbloccato per DIM iterazioni



    //creazione thead, CONDIZIONE INIZIALE
    in = 0;
    out = 0;
    pthread_create(&prod, NULL, (void *)produci, NULL);
    pthread_create(&cons, NULL, (void*)consuma, NULL);


    //attendo terminazione
    pthread_join(prod, NULL);
    pthread_join(cons, NULL);



    return 0;
}
 

