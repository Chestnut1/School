/*
    Creare un programma che metta in ordine un array di stringhe, e che dato un nome dall'utente lo ricerchi nell'elenco.
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

#define NAME 20 //grandezza massima del nome
#define NUM 50  //numero massimo di nome

void loadList(char m[][NAME], int *t);
void orderList(char m[][NAME], int t);
void visualizeList(char [][NAME], int t);
void searchName(char m[][NAME], int t);

main(){
    char list[NUM][NAME];   //lista di nomi
    int names;  //numero di nomi nella lista

    //carico la lista
    loadList(list,&names);

    //ordino i nomi
    orderList(list,names);

    //visualizzo la lista
    visualizeList(list,names);

    //cerco un nome
    searchName(list,names);
}

void loadList(char m[][NAME], int *t){
    int tot;

    //chiedo i nomi totali
    do{
        printf("Nomi totali: ");
        scanf("%d" , &tot);
        system("cls");
    }while(tot<=0 || tot>NUM);

    //carica i nomi
    for(int k = 0; k<tot;k++){
        printf("nome [%d]: " , k);
        fflush(stdin);
        gets(m[k]);
    }

    *t = tot;
    system("cls");
}

void orderList(char m[][NAME], int t){
    int k,i;
    char name[NAME];

    //ordino la lista
    for(k=t-1;k>0;k--){
        for(i=0;i<k;i++){
            if(strcmp(m[i+1],m[i])<0){
                strcpy(name,m[i]);
                strcpy(m[i],m[i+1]);
                strcpy(m[i+1],name);
            }
        }
    }

    printf("\nLista ordinata. Premi invio per visualizzarla.\n");
    getch();
    system("cls");
}

void visualizeList(char m[][NAME], int t){
    for(int k = 0; k < t; k++){
        printf("nome [%d]: %s\n" , k, m[k]);
    }
}

void searchName(char m[][NAME], int t){
    char name[NAME];    //nome da trovare
    bool found = false; //true se trovo il nome

    //chiedo il nome all'utente
    printf("Nome da cercare: ");
    fflush(stdin);
    gets(name);

    //cerco il nome nella lista
    for(int k = 0; k < t && !found; k++){
        if(strcmp(m[k],name)==0){
            found = true;
            printf("Nome %s trovato. Posizione [%d]." , name, k);
        }
    }

    if(!found) printf("Non trovato!");
}
