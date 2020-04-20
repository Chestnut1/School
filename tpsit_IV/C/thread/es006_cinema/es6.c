#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<unistd.h>
#include<stdbool.h>

/*
Ogni cliente copra da 1 a 3 niglietti random
Le casse funzionano in modo simultaneo
*/

//risorse comuni
int biglietti_cinema = 30;
pthread_mutex_t c1 = PTHREAD_MUTEX_INITIALIZER;  //mutex cassa 1
pthread_mutex_t c2 = PTHREAD_MUTEX_INITIALIZER;  //mutex cassa 2

//FUZIONI
void *casse(void* argv){
    int biglietti;  //random da 1 a 3
    //PRIMA SEZIONE CRITICA
    if(pthread_mutex_trylock(&c1) == 0){
 
        printf("CASSA 1:\n");
        biglietti = 1 + rand() %3;
        printf("\tSono il cliente %u, e voglio acquistare %d biglietti.\n" , pthread_self(), biglietti);
        if(biglietti_cinema == 0){
            printf("\tBiglietti acquistati 0\n");
        }else if(biglietti > 0 && biglietti<= biglietti_cinema){
            printf("\tBiglietti acquistati %d\n", biglietti);
            biglietti_cinema -= biglietti;
        }else if(biglietti > 0 && biglietti > biglietti_cinema){
            printf("\tBiglietti acquistati %d\n" , biglietti_cinema);
            biglietti_cinema = 0;
        }
        printf("\t%d biglietti disponibili.\n" , biglietti_cinema);
        pthread_mutex_unlock(&c1);
    }
    
    
    //FINE SEZIONE CRITICA


    //SECONDA SEZIONE CRITICA
    if(pthread_mutex_trylock(&c2) == 0){ 
        printf("CASSA 2:");
        biglietti = 1 + rand() %3;
        printf("\tSono il cliente %u, e voglio acquistare %d biglietti.\n" , pthread_self(), biglietti);
        if(biglietti_cinema == 0){
            printf("\tBiglietti acquistati 0\n");
        }else if(biglietti > 0 && biglietti<= biglietti_cinema){
            printf("\tBiglietti acquistati %d\n", biglietti);
            biglietti_cinema -= biglietti;
        }else if(biglietti > 0 && biglietti > biglietti_cinema){
            printf("\tBiglietti acquistati %d\n" , biglietti_cinema);
            biglietti_cinema = 0;
        }
        printf("\t%d biglietti disponibili.\n" , biglietti_cinema);
        pthread_mutex_unlock(&c2);
        //FINE SECONDA SEZIONE CRITICA
    }

    pthread_exit(NULL);
}


int main(int argv, char **argc){
    pthread_t clienti[20];
    int i;  //contatore
    
    //apro cinema
    for(i=3; i>0; i--){
        printf("Il cinema apre tra %d...\n" , i);
        sleep(1);
    }
    printf("\n\tCINEMA APERTO\n\n");

    //creo tutti i thread (clienti)
    srand(time(NULL));
    for(i=0; i<20; i++){
        pthread_create(&clienti[i], NULL, (void *)casse, NULL);
    }

    //termino tutti i tread prima di terminare il processo padre
    for(i=0; i<20; i++){
        pthread_join(clienti[i], NULL);
    }

    //chiudo cinema
    printf("\n\tCINEMA CHIUSO\n\n");
    return 0;
}