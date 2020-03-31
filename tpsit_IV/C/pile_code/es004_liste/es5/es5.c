/*
    definire una funzione riordinaLista
*/

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct El{
    int valore;
    struct El* next;
};

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

int main(){
    int elementi = 0;    //numero di elementi nella lista
    int n;
    struct El* lista;
    struct El* l;
    lista=NULL; /* inizializzo a NULL, primo elemenot della lista */

    do
    {
        printf("Inserisci un naturale oppure -1 per terminare\n");
        scanf("%d",&n);

        if (n>=0)
        {
            if (lista==NULL) /* controllo se esiste solo una struttura */
            {
                /* alloco lo spazio per una struttura */
                lista = (struct El*) malloc(sizeof(struct El));
                l = lista;
            }
            else /* se il puntatore lista è diverso da NULL*/
            {
                /*assegno al puntatore l dell'elemento corrente un puntatore che punta all'elemento successivo*/
                l->next = (struct El*) malloc(sizeof(struct El));
                l = l->next;
            }

            l->valore = n; /* assegno n al campo dell'elemento corrente*/
            l->next = NULL; /* assegno al campo next dell'elemento corrente NULL */
        }
    } while (n>=0);

    l=lista; /* assegno alla variabile di appoggio l il puntatore al primo elemento della lista */

    l = lista;  //ripunto alla prima struttura della lista

    elementi = stampaLista(l);

    printf("\nDIMENSIONE DELLA LISTA = %d\n" , elementi);

    l = riodrinaLista(l,elementi);

    elementi = stampaLista(l);

    return 0;
}