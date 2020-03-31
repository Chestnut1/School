#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define NGAMES 600
#define MAXCHAR 1024

//defintition of the struct
typedef struct  game{
    int rank;
    char* name;
    char* platform;
    int year;
    char* genre;
    char* publisher;
    float NA_Sales;
    float EU_Sales;
    float JP_Sales;
    float Other_Sales;
    float Global_Sales;
}Game;


/*
----------------------------------------------------------------------------
    declaration of function and prototypes
----------------------------------------------------------------------------
*/
void loadTabFromFile(Game t[], int n, char file[]);

main(){
    //declaration of varaibles
    Game list[NGAMES];  
    char fileName[] = "vgsales.csv";

    //loading data from file
    loadTabFromFile(list,NGAMES,fileName);

    getch();
    fflush(stdin);
}

/*
----------------------------------------------------------------------------
    definition of function and prototypes
----------------------------------------------------------------------------
*/
void loadTabFromFile(Game t[], int n, char file[]){
    FILE *fp;
    int k;
    char * field;
    char * row;

    fp = fopen(file,"r");
    if(fp==NULL){
        printf("\nFatal error. Cannot open %s. Press any key to continue...\n" , file);
        getch();
    }else{
        for (int i = 0; i < n && fgets(row,MAXCHAR,fp)!=NULL; i++){
            if(i!=0){
                field = strtok(row,',');
                t[i].rank = atoi(field);
            }
        }
        
    }
}

