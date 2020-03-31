#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define DIM 50

typedef struct contact
{
    char name[DIM];
    int number;
    struct contact * next;    //struttura autorefernziata
}Contact;


int main(){

    Contact rubrica;

    Contact giovanni;
    strcpy(giovanni.name, "giovanni");
    giovanni.number = 11;
    giovanni.next = NULL;

    Contact mamma;
    strcpy(mamma.name,"mamma");
    mamma.number = 12;
    mamma.next = &giovanni;

    Contact io;
    strcpy(io.name,"io");
    io.number = 13;
    io.next = &giovanni;

    mamma.next= &io;

    Contact* support = &mamma;

    do
    {
        printf("name: %s \t number: %d\n" , support->name, support->number);
        support = support->next;
    } while (support->next != NULL);
    
    

    getch();
    fflush(stdin);
    return 1;
}