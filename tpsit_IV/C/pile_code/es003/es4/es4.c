//write a program in c to show a pointer to an array wich contents are poiter to structure

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define DIM 50

typedef struct structure
{
    char name[DIM];
    int number;
}Structure;


int main(){
    Structure* list;
    int dim = 0;
    printf("Insert dimension of the list:\n");
    scanf("%d" , &dim);

    list = (Structure*) malloc(dim*sizeof(Structure));

    printf("size of structure = %d\n" , sizeof(Structure));

    for (int i = 0; i < dim; i++)
    {
        char temp[DIM];
        printf("%d = " , i);

        fflush(stdin);
        gets(temp);

        printf("\n");

        strcpy((i+list)->name, temp);

        (i+list)->number = i;
    }
    

    for (int k = 0; k < dim; k++){
        printf("pointer list [%d] = %p\n" , k , (list+k));
    }

    for (int i = 0; i < dim; i++)
    {
        printf("structure %d\n " , i);
        printf("name: %s \t number: %d" ,(list+i)->name , (list+i)->number );
        printf("\n");
    }
    

    
    free(list);

    getch();
    fflush(stdin);
    return 1;
}