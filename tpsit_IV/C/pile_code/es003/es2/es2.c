//write a program in c to find the largest element using DMA

#include<stdio.h>
#include<stdio.h>

main(){
    int* v;
    int dim;
    int max;

    printf("Insert the dimension of the int vector:\n");
    scanf("%d" , &dim);

    v = (int*) malloc(dim*sizeof(int));

    for (int k = 0; k < dim; k++){
        printf("v[%d] -> " , k);
        scanf("%d" , v+k);
    }

    max = *v;
    printf("starting max = %d\n" , max);

    for(int i = 1; i<dim; i++){
        if(*(v+i)>max) max = *(v+i);
    }

    printf("final max = %d" , max);

    getch();
    fflush(stdin);
}