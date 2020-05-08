var something

do{
    something = prompt("Inserisci qualcosa: ", "User")
}while(something == null)   // ciclo fino a quando non si inserisce qualcosa

prompt("Hai inserito " + something)