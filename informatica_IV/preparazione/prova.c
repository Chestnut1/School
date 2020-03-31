#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include<string.h>

#define LUNG 20
#define NMAXVOTI 10
#define NMAXMATERIE 15

/*----------------------------------------------------------------------
    DEFINIZIONE DI STRUTTURE
------------------------------------------------------------------------*/
typedef struct{
    int g;
    int m;
    int a;
} Data;

typedef struct{
    Data giorno;
    float voto;
    float peso;
    char tipo; // S o P o O oppure TipoVoto tipo;
} Voto;

typedef struct{
    char nome[LUNG];
    Voto voti[NMAXVOTI];
    int nVoti;
    float media;
} Materia;

typedef struct{
    int periodo;
    Materia votiMaterie[NMAXMATERIE];
    int nMaterie;
} Pagella;

/*----------------------------------------------------------------------
    DICHIARAZIONE DI FUNZIONI E PROCEDURE
------------------------------------------------------------------------*/

Data creaData(int g, int m, int a); //inserisci controllo correttezza data
void stampaData(Data d);

Voto creaVoto(Data giorno, float voto, float peso, char tipo); //con controllo dati
void stampaVoto(Voto v);

Materia creaMateria(char nome[]); //inizializza nVoti
void stampaMateria(Materia m);
void aggiungiVoto(Materia *m, Voto v);

Pagella creaPagella(int periodo); //inizializza nMaterie
void stampaPagella(Pagella p);
void aggiungiMateria(Pagella *p, Materia m);
void aggiungiVotoMateria(Pagella *p, char nomeMateria[], Voto v);

/*----------------------------------------------------------------------
    MAIN
------------------------------------------------------------------------*/
int main(void) {

	printf("Creo una data:\n");
	Data oggi = creaData(2,13,2019);
	printf("oggi e\': ");
	stampaData(oggi);
	printf("\n");

	printf("Creo un voto:\n");
	Voto v= creaVoto(oggi,(float)7.5, (float)2, 'S');
	stampaVoto(v);
	printf("\n");

    printf("\nCreo una materia:\n");
    Materia nuovaMateria = creaMateria("info");
    stampaMateria(nuovaMateria);
    aggiungiVoto(&nuovaMateria,v);
    aggiungiVoto(&nuovaMateria, creaVoto(creaData(3,10,2019), (float)6.0,1,'S'));
    stampaMateria(nuovaMateria);

    printf("creo una pagella:\n");
    Pagella p = creaPagella(1);
    stampaPagella(p);
    aggiungiMateria(&p,nuovaMateria);
    stampaPagella(p);

    printf("Aggiungo altre due materie\n");
    Materia m1 = creaMateria("storia");
    Materia m2 = creaMateria("TPSIT");
    aggiungiVoto(&m1,creaVoto(oggi,(float)8, (float)2, 'S'));
    aggiungiVoto(&m2,creaVoto(oggi,(float)5, (float)1, 'O'));
    aggiungiMateria(&p,m1);
    aggiungiMateria(&p,m2);

    stampaPagella(p);
	return 0;
}


/*----------------------------------------------------------------------
    DEFINIZIONE DI STRUTTURE
------------------------------------------------------------------------*/
Data creaData(int g, int m, int a){
   int v[]={31,28,31,30,31,30,31,31,30,31,30,31};
   Data d;

	if (m > 0 && m < 13){
    	d.m=m;
	}else{
    	d.m=1;
	}
	if (v[m-1] >= g && g > 0){
        	d.g=g;
	}else {
        	d.g=1;
	}
	if (a > 0){
    	d.a=a;
	}else {
    	d.a=2000;
	}

   return d;
}


void stampaData(Data d){
    printf("%d/%d/%d", d.g, d.m, d.a);
}

Voto creaVoto(Data giorno, float voto, float peso, char tipo){ //con controllo dati
	Voto v;
    v.giorno = giorno;

    if(voto>=1 && voto<=10){
        v.voto = voto;
    }else{
        v.voto = 1;
    }
    if(peso >= 0){
        v.peso = peso;
    }else{
        v.peso=1;
    }
    if(tipo == 'T' || tipo == 'S' || tipo == 'O'){
        v.tipo = tipo;
    }else{
        v.tipo = 'O';
    }

    return(v);
}

void stampaVoto(Voto v){
    printf("%c %.2f (%.2f)" , v.tipo, v.voto, v.peso);
	stampaData(v.giorno);
}

Materia creaMateria(char nome[]){
    Materia materia;

    strcpy(materia.nome,nome);

    materia.media = 0;

    materia.nVoti = 0;

    return materia;
}

void stampaMateria(Materia m){
    float mediaPesata = 0;
    float sommaPesi = 0;
    float sommaVotiPesati = 0;
    int k;

    printf("%s:\n" , m.nome);

    for(k=0;k<m.nVoti;k++){
        stampaVoto(m.voti[k]);
        sommaPesi += m.voti[k].peso;
        sommaVotiPesati += m.voti[k].peso * m.voti[k].voto;
        sommaPesi += m.voti[k].peso;
        printf("\n");
    }

    if(sommaPesi == 0){
         printf("Nessun voto caricato.\n");
    }else{
        mediaPesata = sommaVotiPesati/sommaPesi;
        printf("Media pesata: %.2f\n" , mediaPesata);
    }
}

void aggiungiVoto(Materia *m, Voto v){
    if(m->nVoti<NMAXVOTI){
        m->voti[m->nVoti] = v;
        m->nVoti++;
    }
}

Pagella creaPagella(int periodo){
    Pagella p;
    if(periodo>0 && periodo <4){
        p.periodo = periodo;
    }else{
        p.periodo = 1;
    }

    p.nMaterie = 0;
    return p;
}

void stampaPagella(Pagella p){
    printf("Periodo %d :\n" , p.periodo);
    for(int k = 0; k<p.nMaterie;k++){
        stampaMateria(p.votiMaterie[k]);
    }
}

void aggiungiMateria(Pagella *p, Materia m){
    if(p->nMaterie<NMAXMATERIE){
        p->votiMaterie[p->nMaterie] = m;
        p->nMaterie++;
    }
}

void aggiungiVotoMateria(Pagella *p, char nomeMateria[], Voto v){
    int tro = -1;
    int k = 0;

    while(k<p->nMaterie && tro == -1){
        if(strcmp(p->votiMaterie[k].nome, nomeMateria)==0){
            tro = k;
        }
        k++;
    }

    if(tro == -1){
        printf("Materia inesistente.\n");
    }else{
        aggiungiVoto(&p->votiMaterie[tro],v);
    }
}



