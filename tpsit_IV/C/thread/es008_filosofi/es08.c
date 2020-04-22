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

pthread_mutex_t mutex, mutex_f[N];  //per accesso alle sezioni critiche (le forchette sul tavolo)
int stato[N];   //variabile condivisa, contiene stato filosofi

void pensa(int i){
    printf("\nFILOSOFO %d sto pensando...\n", i);
    sleep(rand()%N);    //randomizzo tempo per pensare
}

void mangia(int i){
    printf("\nFILOSOFO %d sto mangiando...\n", i);
    sleep(rand()%N);    //randomizzo tempo per mangiare
}

void controllaPosate(int i){
    if(stato[i] == ATTESA && stato[DESTRA] != MANGIA && stato[SINISTRA] != MANGIA){
        stato[i] = MANGIA;
        printf("\nFILOSOFO %d: prendo le forchette e mangio" , i);
    }else{
        printf("\nFILOSOFO %d: forchette occupate, attendo per mangiare" , i);
    }
}

void prendi(int i){
    pthread_mutex_lock(&mutex); //accesso in mutua esclusione
    printf("\nFILOSOFO %d: ho fame e aspetto le forchette...\n", i);
    stato[i] = ATTESA;

    controllaPosate(i); //controllo e attendo posata
    
    pthread_mutex_unlock(&mutex);
}

void posa(int i){
    pthread_mutex_lock(&mutex); //accesso in muta esclusione
    stato[i] = PENSA;   //modifico lo stato (prevengo starvation e dead lock)
    pthread_mutex_unlock(&mutex);   //rilasio la sezione critica
}

void *filosofo(void *arg){
    int i = (*(int*)arg);   //casting
    while(1){
        //pensano
        pensa(i);
        //prendere le posate
        prendi(i);
        //se le prendono mangiano
        mangia(i);
        //posano forchetta
        posa(i);
    }
}

int main(int argc, char **argv){
    int i;  //indice
    pthread_t filo[N];  //filosofi

    //inizialissi il semafoto di accesso
    pthread_mutex_init(&mutex, NULL);

    //inizializzo mutex f
    for(int i=0; i<N; i++){
        pthread_mutex_init(&mutex_f[i], NULL);
    }

    //creo e lancio i miei thread (filosofi)
    for(int i=0; i<N; i++){
        pthread_create(&filo[i], NULL, (void *)filosofo, (void*)&i);
    }

    return 0;
}



