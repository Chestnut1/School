#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

#define NAME 10
#define LUNG 4  //numero di stati

//per comodità ci sono solo italia, francia, germania, spagna

//definsico la struttura
typedef struct state{
    char name[NAME];
    char capitalCity[NAME];
    int km2;
    int citizens;
}State;

/*-------------------------------------------------------------------------
  PROTOTIPI DI FUNZOIONI E PROCEDURE
  -------------------------------------------------------------------------*/

void laodTabFromFile(State t[], int n, char fn[]);     //carica la tabella da file
void orderList(State t[], int n);                      //ordino la lista secondo l'alfabeto
void visualizeList(State t[], int n);                       //visualizzo la lsita

main(){
    //dichiarazione di variabili
    State list[LUNG];   //tabella
    char fileName[NAME] = "stati.txt";

    //carico la tabella
    laodTabFromFile(list, LUNG, fileName);

    //ordino la lista
    orderList(list, LUNG);

    //visualizzo la lista
    visualizeList(list,LUNG);

    getch();
    fflush(stdin);
}

/*-------------------------------------------------------------------------
  DEFINIZIONE DI PROCEDURE E FUNZIONI
  -------------------------------------------------------------------------*/

void laodTabFromFile(State t[], int n, char fn[]){
    FILE *fp;
    int k;
    
    //apro il file e copio i dati nella tabella
    fp=fopen(fn,"r");
    if(fp==NULL){
        printf("File \"%s\" inesistente. Premere qulasiasi tasto per terminare il programma..." , fn);
        getch();
        system("cls");
    }else{
        while (fscanf(fp,"%s %s %d %d" , t[k].name, t[k].capitalCity, &t[k].km2, &t[k].citizens)!=EOF){
            k++;
        }
        printf("|Tabella caricata con successo|\nPremere un tasto per continuare.\n");
        getch();
        system("cls");
    }

    fclose(fp);
}

void orderList(State t[], int n){
    State support;  //variabile di supporto

    for(int i=0; i<n; i++){
        for(int k=0; k<n-i-1; k++){
            if(strcmp(t[k+1].name,t[k].name)<0){
                support = t[k+1];
                t[k+1]=t[k];
                t[k] = support;
			}
		}
	}
    
}

void visualizeList(State t[], int n){
    for (int i = 0; i < n; i++){
        printf("|STATO|     %s\n|CAPITALE|     %s\n|SUPERFICE|     %d\n|ABITANTI|     %d\n" , t[i].name, t[i].capitalCity, t[i].km2, t[i].citizens);

        printf("-----------------------------------------------------------------------------\n");
    }

    getch();
}
