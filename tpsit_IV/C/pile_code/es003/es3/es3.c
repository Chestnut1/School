//write a program in c to calculate the length of a string

#include<stdio.h>
#include<stdio.h>
#include<string.h>

int main(){
    char* string;
    int length = 0;

    string = (char*) malloc(50*sizeof(char));

    printf("Insert the string: \n");
    gets(string);
    printf("string = %s" , string);

    while(*string!='\0'){
        printf("in while");
        length++;
        string++;
    }

    printf("Length = %d" , length);
    

    fflush(stdin);
    return 1;
}