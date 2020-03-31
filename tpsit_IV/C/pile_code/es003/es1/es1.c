//wrtie a program in c to store n elements in an array and print the elements using pointer

#include<stdio.h>
#include<stdlib.h>


main(){
    int* v;
    int dim;

    printf("\nInsert the dimension of the int vector:\n");
    scanf("%d" , &dim);

    v = (int*) malloc(dim*sizeof(int));

    for (int k = 0; k < dim; k++){
        printf("v[%d] -> " , k);
        scanf("%d" , v+k);
    }

    for(int i = 0; i<dim; i++){
        printf("v[%d] = %d\n" , i, *(v+i));
    }
    
    getch();
    fflush(stdin);
}