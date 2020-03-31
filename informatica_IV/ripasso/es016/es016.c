#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>

#define PROVE 10
#define NAME 20
#define PARTECIPANTS 3


//definsico la struttura
typedef struct partecipant{
    char name[NAME];
    int challenge[PROVE];
}Partecipant;


/*
-------------------------------------------------------------------------
    PROTOTIPI DI PROCEDURE E FUNZIONI
-------------------------------------------------------------------------
*/
void laodTabFromFile(Partecipant t[], int n, char fn[]);     //carica la tabella da file
void visualizeList(Partecipant t[], int n);                        //visualizzo la lsita

main(){
    //dichiarazione di variabili
    Partecipant list[PARTECIPANTS];     //tabella con i partecipanti
    char fileName[NAME] = "gara.txt";

    //carico la tabella
    laodTabFromFile(list,PARTECIPANTS,fileName);

    //visualizzo la tabella
    visualizeList(list,PARTECIPANTS);

    //printo i vincitori per sfida
    

    getch();
    fflush(stdin);
}


/*
-------------------------------------------------------------------------
    DEFINIZIONE DI PROCEDURE E FUNZIONI
-------------------------------------------------------------------------
*/
void laodTabFromFile(Partecipant t[], int n, char fn[]){
    FILE *fp;
    int k=0,i=0;
    
    //apro il file e copio i dati nella tabella
    fp=fopen(fn,"r");
    if(fp==NULL){
        printf("File \"%s\" inesistente. Premere qulasiasi tasto per terminare il programma..." , fn);
        getch();
        system("cls");
    }else{
        while (fscanf(fp, "%s" , t[k].name)!=EOF){
            for (int i = 0; i < PROVE; i++){
                fscanf(fp,"%d" , t[k].challenge[i]);
            }
            
            k++;
        }
        printf("|Tabella caricata con successo|\nPremere un tasto per continuare.\n");
        getch();
        system("cls");
    }

    fclose(fp);
}

void visualizeList(Partecipant t[], int n){

    for (int i = 0; i < n; i++){

        printf("\n|%s|" , t[i].name);

        for (int k = 0; k < PROVE; k++){
            printf("[%d]" , t[i].challenge[k]);
        }
        

        printf("\n-----------------------------------------------------------------------------\n");
    }

    getch();
}
