#include<stdio.h>
#include<stdlib.h>


main(){
    int n;
    int* v;
    printf("Inserisci la dimensione: ");
    scanf("%d" , &n);

    v = (int*) malloc(5*sizeof(int));

    for(int k = 0; k<n; k++){
        printf("v[%d] = " , k);
        scanf("%d" , &v[k]);
    }

    for(int i = 0; i<n; i++){
        printf("v[%d] = %d\n" , i , v[i]);
    }

    getch();
    fflush(stdin);
}