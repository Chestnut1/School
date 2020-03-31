#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
main(){
    //dichiarazione di varaibili
    char fileName[]="teto.txt";
    char newFileName[]="poesia.txt";
    char row[1000];
    FILE *fp;
    FILE *fp2;
    int k = 0;
    fp = fopen(fileName,'r');
    fp2 = fopen(newFileName,'w');
    if (fp==NULL){
        printf("file %s non esiste\n" , fileName);
    }else{
        while(fgets(row,1000,fp)!=NULL){
            if(k%2!=0){
                fprintf(fp2, "%s" , row);
            }
            k++;
        }
    }
    fclose(fp);
    fclose(fp2);
}
