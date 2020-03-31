/*
**Aurhor: Bruno Luca
**
**Es3: Implementare le pile e i metodi pop() e push() utilizzando una coda con i suoi metodi enqueue()
**     and dequeue().
**     (essenzialmente devo implementare una enqueue che mi inserisce l'elemento in cima alla coda)
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

struct El{
    int valore;
    struct El* next;
}El;

//funzione che controlla se una coda è vuota oppore no
bool is_empty(struct El* head){
    return (head==NULL) ? true: false;
}

//funzione che inserisce un elemento in una coda
void enqueue(struct El** head, struct El** tail, struct El* element){
    if(is_empty(*head)){ 
        *head = element;
    }else{
        (*tail)->next = element;
    }
    *tail = element;
    element->next = NULL;
}

//funzione che toglie il primo elemento di una coda
struct El* dequeue(struct El** head, struct El** tail){
    struct El* ret = *head;

    if(is_empty(*head)) return NULL;
    else *head = ret->next;

    if(*head == NULL) *tail = NULL;

    return ret;
}

//funzione che inserisce un elemento in una pila
void push(struct El** head, struct El* element){
    if(&head == NULL){
        *head = element;
        element->next = NULL;
    }else{
        element->next = *head;
        *head = element;
    }
}

//funzione che toglie un elemento dalla pila
struct El* pop(struct El** head){
    struct El* ret = *head;
    if(&head == NULL) return NULL;
    else *head = ret->next;

    return ret; 
}

int main(){
    //creo la coda e la testa (inizializzata a NULL)
    struct El* tail = (struct El*) malloc(sizeof(struct El));    //puntatore alla coda
    struct El* head = (struct El*) malloc(sizeof(struct El));    //putatore alla testa
    head = NULL;

    //strutture che contiene il numero 
    struct El* element; //numero dell'utente
    int numero = 0; //numero preso da tastiera

    char risp = 's';  //risposta dell'utente
    int n = 0;  //numero di elementi nella coda

    //continuo a chiedere numeri al'utente fa inserire nella coda
    do{
        system("cls");

        if(is_empty(head)) printf("testa vuota\n");

        //chiedo il numero e lo carico nella struttura
        printf("numero:\t");
        scanf("%d" , &numero);
        printf("\n%p" , head);
        element = (struct El*) malloc(sizeof(struct El));
        element->valore = numero;   

        //inserisco la struttura nella coda
        enqueue(&head, &tail, element);

        //cheido vuole inserire altri numeri
        printf("\n%p" , head);
        printf("\n\nAltri numeri? (s/n)  ");
        fflush(stdin);
        scanf("%c" , &risp);

        n++;
    }while(risp == 's' || risp == 'S');

    printf("\n|LISTA CARICATA|\n");

    //chiedo l'elemento da inserire in cima e lo metto dentro element
    printf("Inserisci l'elemento che vuoi inserire in cima : ");
    scanf("%d" , &numero);
    element = (struct El*) malloc(sizeof(struct El));
    element->valore = numero;
    enqueue(&head, &tail, element);

    //stampo la coda con i valori invertiti
    for(int i = 0; i<n; i++){
        //tolgo l'elemento dalla coda
        element = dequeue(&head,&tail);
        printf("%d" , element->valore);

    }


    return 0;
}