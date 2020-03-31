#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>

#define LUNG 10    //lunghezza per nomi
#define DIM 3      //grandezza della rubrica

//definizione della struttra
typedef struct contact{
    char name[LUNG];
    char surname[LUNG];
    char gender;
    char address[LUNG];
    int phone;
    int age;
}Contact;

//prototipi di funzioni e procedure
void visualizeMenu();       //visualizza il menu
void loadRubric(Contact rubric, int n);    //aggiounge un elemento
bool findElement();         //cerca un elemento
void visualizeAll();        //visualizza tutta la lista
void ageAverage();          //media dell'età M e F
void editElement();         //modifica un elemento
void incAge();              //incrementa tutte le età di 1

main(){

    //definizione di variabili
    bool exit = false;
    Contact rubric[DIM];
    int choice;

    do{
        //chiedo all'utente cosa vuole fare
        do{
            visualizeMenu();
            scanf("%d" , &choice);
        }while(choice<0 || choice>6);
        system("cls");

        switch(choice){
        case 0:
            exit = true;
            break;
        case 1:
            loadRubric(rubric,DIM);
            break;
        case 2:
            findElement();
            break;
        case 3:
            visualizeAll();
            break;
        case 4:
            ageAverage();
            break;
        case 5:
            editElement();
            break;
        case 6:
            incAge();
            break;
        default;
    }while(!exit);
}

//definizione di prototipi
void visualizeMenu(){
    printf("0>Esci\n1>Inserisci nuovo elemento\n2>cerca elemento\n3>visualizza tutto\n4>eta' media di maschi e femmine\n5>modifica elemento\n6>incrementa l'et' di ogni elemento di uno\n");
}

void insertNewElement(Contact r[], int n){
    Contact newElement; //nuovo elemento
    Contact support;    //struttare di supporta per caricare in modo ordinato

    char n[LUNG];
    char s[LUNG];
    char add[LUNG];

    //carico la tabella
    for(int k = 0; k<n; k++){
        //chiedo le informazioni
        printf("Nome: ");
        gets(n);
        strcpy(r[k].name);
        printf("Cognome: ");
        gets(s);
        strcpy(r[k].surname);
        scanf("Sesso: ");
        scanf("%c" , r[k].gender);
        printf("Indirizzo: ");
        gets(add);
        strcpy(r[k].address);
        printf("Telefono: ");
        scanf("%d" , r[k].phone);
        printf("Eta': ");
        scanf("%d" , r[k].age);

        getch();
        system("cls");
    }



    for(k=n-1;k>0;k--){
        for(i=0;i<k;i++)
            if(strcmp(newElement.name,r[k].name)<0){


            if(strcmp(m[i+1],m[i])<0){
                strcpy(name,m[i]);
                strcpy(m[i],m[i+1]);
                strcpy(m[i+1],name);
            }
        }
    }

}
