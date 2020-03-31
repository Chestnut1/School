/*
    creare la funzione merge chericeve come argomenti due liste ordinate e n crea un'unica anch'essa ordinata
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct El{
    int valore;
    struct El* next;
};

struct El* caricaLista(struct El* ListaDiElementi){
    int n;
    struct El* lista;
    struct El* l;
    lista=NULL; /* inizializzo a NULL, primo elemenot della lista */
    do{
        printf("Inserisci un naturale oppure -1 per terminare\n");
        scanf("%d",&n);

        if (n>=0){
            if (lista==NULL){ /* controllo se esiste solo una struttura */
                /* alloco lo spazio per una struttura */
                lista = (struct El*) malloc(sizeof(struct El));
                l = lista;
            }
            else{ /* se il puntatore lista è diverso da NULL*/
                /*assegno al puntatore l dell'elemento corrente un puntatore che punta all'elemento successivo*/
                l->next = (struct El*) malloc(sizeof(struct El));
                l = l->next;
            }

            l->valore = n; /* assegno n al campo dell'elemento corrente*/
            l->next = NULL; /* assegno al campo next dell'elemento corrente NULL */
        }
    } while (n>=0);

    l=lista; /* assegno alla variabile di appoggio l il puntatore al primo elemento della lista */

    return l;
}

int stampaLista(struct El* ListaDiElementi){
    int k;

    while (ListaDiElementi->next != NULL){
        printf("|%d|\t-->\t%p\n" , ListaDiElementi->valore, ListaDiElementi);
        ListaDiElementi = ListaDiElementi->next;
        k++;
    }
    if (ListaDiElementi->next == NULL)
    {
        printf("|%d|\t-->\t%p\n" , ListaDiElementi->valore, ListaDiElementi);
        ListaDiElementi = ListaDiElementi->next;
        k++;
    }

    return k;
    
}

struct El* riodrinaLista(struct El* ListaDiElementi, int dim){
    struct El* inizioLista = ListaDiElementi;
    int scambio = 0;

    int dx;
    int k;

    for(dx = dim-1; dx>=1 ; dx--){
        ListaDiElementi = inizioLista;
        for(k=0;k<dx;k++){
            if(ListaDiElementi->valore > ListaDiElementi->next->valore){
                scambio = ListaDiElementi->valore;
                ListaDiElementi->valore = ListaDiElementi->next->valore;
                ListaDiElementi->next->valore = scambio;
            }
            ListaDiElementi = ListaDiElementi->next;
        }
         
    }

    return inizioLista;
}

struct El* merge(struct El* l, struct El* l2, int dim, int dim2){
    //alloco in memoria lo spazio per la lista unita
    struct El* uniList = (struct El*) malloc(sizeof(struct El)*(dim+dim2));
    struct El* inizio = uniList;
    {
        /* data */
    };
    

    for (int i = 0; i < dim; i++){
        uniList->valore = l->valore;
        uniList = uniList->next;
        l = l->next;
    }
    for (int i = 0; i < dim2; i++){
        uniList->valore = l2->valore;
        uniList = uniList->next;
        l2 = l2->next;
    }

    return inizio;
    
}

int main(){
    //creo la prima lista, la riordino e la printo
    struct El* list = caricaLista(list);
    printf("\n|LISTA 1 NON ORDINATA|\n");
    int elementi = stampaLista(list);
    list = riodrinaLista(list,elementi);
    printf("\n|LISTA 1 ORDINATA|\n");
    elementi = stampaLista(list);
    printf("\nelementi = %d\n" , elementi);

    //creo la seconda lista, la riordino e la printo
    struct El* list2 = caricaLista(list2);
    printf("\n|LISTA 2 NON ORDINATA|\n");
    int elementi2 = stampaLista(list2);
    list2 = riodrinaLista(list2,elementi2);
    printf("\n|LISTA 2 ORDINATA|\n");
    elementi2 = stampaLista(list2);
    printf("\nelementi = %d\n" , elementi2);

    return 0;
}