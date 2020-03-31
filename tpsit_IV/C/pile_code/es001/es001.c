#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NGAMES 600
#define ROWMAX 1024

//definisco la struttura
    typedef struct game{
        int rank;
        char *name;
        char *platform;
        int year;
        char *genre;
        char *publisher;
        float NA_Sales;
        float EU_Sales;
        float JP_Sales;
        float Other_Sales;
        float Global_Sales;
    }Game;


//prototipi
void loadTabFromFile(char n[], Game l[]); //carico la tabella da file
void visualizeElement(Game t[], int n);     //viusalizzo n elementi della lista

main(){
    //definizione di variabili
    char filename[30] = "vgsales.csv";
    Game list[NGAMES]; //creo la tabella

    //carico la tabella da file
    loadTabFromFile(filename,list);

    int n;
    printf("Inserisci n elementi:\n");
    scanf("%d" , &n);

    //printo tot elementi
    visualizeElements(list,n);

    getch();
    fflush(stdin);
}

void loadTabFromFile(char n[], Game l[]){
    printf("appena entrato\n");
    FILE *fp;
    char *row;
    int i = 0;

    printf("prima file\n");
    fp = fopen(n,"r");
    printf("dopo file\n");

    printf("controllo\n");
    if(fp==NULL){
        printf("file %s non trovato\n" , n);
        getch();
    }else{
        printf("file trovato\n");
        /*
        for (int i = 0; i < NGAMES && fgets(row,ROWMAX,fp); i++){
            printf("dentro for \n");
            if(i!=0){
                printf("inizio ciclo diverso 1\n");
                l[i].rank = atoi(strtok(row, ',')); 
                strcpy(l[i].name , strtok(NULL, ','));
                strcpy( l[i].platform,strtok(NULL, ','));
                l[i].year = atoi(strtok(NULL, ','));
                strcpy( l[i].genre,strtok(NULL, ','));
                strcpy( l[i].publisher,strtok(NULL, ','));
                l[i].NA_Sales = atof(strtok(NULL, ','));
                l[i].EU_Sales = atof(strtok(NULL, ','));
                l[i].JP_Sales = atof(strtok(NULL, ','));
                l[i].Other_Sales = atof(strtok(NULL, ','));
                l[i].Global_Sales = atof(strtok(NULL, ','));
                printf("%d\n" , i);
            }
        }
        */

        if(i==0 && fgets(row,ROWMAX,fp)){
            printf("prima riga \t %d %s %s %d %s %s %f %f %f %f %f", l[i].rank, l[i].name,l[i].platform, l[i].year, l[i].genre, l[i].publisher, l[i].EU_Sales, l[i].JP_Sales, l[i].Other_Sales, l[i].Global_Sales);
        }
        i++;
        while (fgets(row,ROWMAX,fp)){
                printf("inizio ciclo diverso 1\n");
                l[i].rank = atoi(strtok(row, ',')); 
                strcpy(l[i].name , strtok(NULL, ','));
                strcpy( l[i].platform,strtok(NULL, ','));
                l[i].year = atoi(strtok(NULL, ','));
                strcpy( l[i].genre,strtok(NULL, ','));
                strcpy( l[i].publisher,strtok(NULL, ','));
                l[i].NA_Sales = atof(strtok(NULL, ','));
                l[i].EU_Sales = atof(strtok(NULL, ','));
                l[i].JP_Sales = atof(strtok(NULL, ','));
                l[i].Other_Sales = atof(strtok(NULL, ','));
                l[i].Global_Sales = atof(strtok(NULL, ','));
                printf("%d\n" , i);
                i++;
        }
        
    }
    fclose(fp);
}

void visualizeElements(Game t[], int n){
    for(int k = 0; k < n ; k++){
        printf("%d %s %s %d %s %s %f %f %f %f %f\n", t[k].rank, t[k].name, t[k].platform, t[k].year, t[k].genre, t[k].publisher, t[k].NA_Sales, t[k].EU_Sales, t[k].JP_Sales, t[k].Other_Sales, t[k].Global_Sales);
    }
}
