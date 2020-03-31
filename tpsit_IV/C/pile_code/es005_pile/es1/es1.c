/*
Autore: Gabriele bagnis
Data: 21/11/2019
Es 1 Pile: Creare un programma che dato un numero intero, avente un numero arbitrario di cifre inserite
dall’utente, lo scriva in output con le cifre in ordine inverso. Utilizzare una pila e le implementazioni
dei metodi push e pop
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

struct El{
    int valore;
    struct El* next;
}El;

void push(struct El** head, struct El* element){
	if (&head==NULL){
		*head = element;
		element->next = NULL;
	}else{
		element->next = *head;
		*head = element;
	}
}

struct El* pop(struct El** head){
	struct El *ret = *head;
	if(&head==NULL){
		return NULL;
	}else{
		*head = ret->next;
	}
	return ret;
}

void stampaPila(struct El** head){  //stampo la pila
    struct El *ret;
    ret=pop(head);
    while(ret!=NULL){   //ripeto finchè ci sono elementi
        printf("\n%d",ret->valore);
        free(ret);
        ret=pop(head);  //leggo il prossimo elemento
    }
}

int main(){

    struct El* head;
    struct El* element;
    char stringaDiNumeri[1000];

    //chiedo il numero all'utente
    printf("Inserisci i nuneri:\n");
    fflush(stdin);
    scanf("%s", stringaDiNumeri);

    //carico i numeri nella pila
    for(int k = 0; stringaDiNumeri[k]!='\0'; k++){
        element = (struct El*) malloc(sizeof(struct El));
        element->valore = stringaDiNumeri[k] - 48;    //da char diventa int
        push(&head,element);
    }

    printf("|CARICAMNETO COMPLETATO|");

    //stampo la pila
    stampaPila(&head);

    return 0;
 }

