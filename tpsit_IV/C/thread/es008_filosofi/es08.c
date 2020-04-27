#include<stdio.h>
#include<pthread.h>
#include<unistd.h>
#include<stdlib.h>

#define N 5
#define PENSA 0
#define ATTESA 1
#define MANGIA 2

#define DESTRA (i+1)%N      //con queste due fromule ho sempre a disposizione il filosof a destra e a sinistra
#define SINISTRA (i-1+N)%N

pthread_mutex_t mutex, mutex_f[N];  //mutex per risorse critiche, mutex_f per le forchette
int stato[N];   //stato di ogni filosofo

void *pensa(int i){
    printf("\nFILOSOFO %d, sto pensando..." , i);
    sleep(rand()%N);
}

void *mangia(int i){
    printf("\nFILOSOFO %d, sto mangiando..." , i);
    sleep(rand()%N);
}

void controllaPosate(int i){
    if(stato[i] == ATTESA && stato[DESTRA] != MANGIA && stato[SINISTRA] != MANGIA){
        stato[i] = MANGIA;
        printf("\nFILOSOFO %d, prendo le posate e mangio..." , i);
    }else{
        printf("\nFILOSOFO %d, forchette occupate, atteno per mangiare..." , i);
    }
}

void *prendi(int i){
    pthread_mutex_lock(&mutex); //accesso in mutua esclusione
    printf("\nFILOSOFO %d, ho fame e aspetto le forchette...", i);

    stato[i] = ATTESA;

    controllaPosate(i); //controlliamo e attendimao le posate

    pthread_mutex_lock(&mutex_f[i]);    //blocca la sua risorsa
    pthread_mutex_unlock(&mutex);
}

void *posa(int i){
    pthread_mutex_lock(&mutex);
    stato[i] = PENSA;   //aggiorno lo stato
    pthread_mutex_unlock(&mutex_f[i]);  //libera la sua risorsa
    pthread_mutex_unlock(&mutex);
}


void *filosofo(void *arg){
    int i = (*(int*)arg);

    while(1){
        //pensa
        pensa(i);
        //prende
        prendi(i);
        //mangia
        mangia(i);
        //posa 
        posa(i);
    }

}

int main(int argc, char **argv){
    int i = 0;  //indice
    pthread_t filo[N];  //filosofi

    //inizializzo il semaforo ad acceso
    pthread_mutex_init(&mutex, NULL);

    //inizializzo le mutex dei filosofi
    for(i=0; i<N; i++){
        pthread_mutex_init(&mutex_f[i], NULL);
    }

    //creo e lancio i miei thread (filosofi)
    for(i = 0; i < N; i ++){
        pthread_create(&filo[i], NULL, (void *) filosofo, (void *)&i);
        sleep(1);
    }
    pthread_exit(0);

    return 0;
}




