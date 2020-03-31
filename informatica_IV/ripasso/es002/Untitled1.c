#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>

#define NC 5    //numero di celle, uguale per righe e per colonne
#define NAME 10    //lunghezza massima del nome

void loadMatrixFromFile(int m[][NC], char fileName[]);
void visualizeMatrix(int m[][NC]);
bool isUnaria(int m[][NC]);

main(){
    //dichiarazione di variabili
    int m[NC][NC];    //matrice
    char fileName[] = "file.txt";

    //carico la matrice
    loadMatrixFromFile(m,fileName);

    //visualizzo la matrice
    visualizeMatrix(m);

    //controllo sull'unaria
    if(isUnaria(m))printf("Unaria");
    else printf("Non unaria");

    gtech();
    fflush(stdin);
}

void loadMatrixFromFile(int m[][NC], char fileName[]){
    FILE *fp;

    fp = fopen(fileName,"r");

    if(fp==NULL){
        printf("File inesistente");
    }else{
        //carico la matrice
        for(int k = 0; k<NC; k++){
            while(fscanf(fp,"%d %d %d %d %d" , &m[k][0],&m[k][1],&m[k][2],&m[k][3],&m[k][4])){
        }

        printf("matrice caricata. Premere qualsiasi tasto per continuare...\n");
        getch();
    }
    fclose(fp);
}

void visualizeMatrix(int m[][NC]){
    for(int k= 0; k<NC;k++){
        for(int k1 = 0; k1<NC; k1++){
            printf("[%d]" , m[k][k1]);
        }
        printf("\n");
    }
}

bool isUnaria(int m[][NC]){
    bool unaria = true;

    for(int k = 0; k<NC && unaria; k++){
        for(int k1 = 0; k1<NC && unaria; k1++){
            if((k1==k && m[k][k1]!=1) || (k!=k1 && m[k][k1]  != 0)) {
                unaria = false;
            }
        }
    }

    return unaria;
}




