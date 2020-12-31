#include <iostream>
using namespace std;

int main(){
    //chiedo la parola da criptare
    string msg;
    string msg_criptato;
    int shift;
    int lg;
    int index;  //contatore per la criptazione
    string alfabeto = "abcdefghijklmnopqrstuvwxyz";

    cout << "Inserisci lo shift da usare\n";
    cin >> shift;
    cout << "Inserisci la parola da cifrare\n";
    cin >> msg;

    lg = msg.length();

    //rendo la stringa tutta minuscola
    for(int i = 0; i < lg; i++){
        msg[i] = tolower(msg[i]);
    }

    cout << "\n\n--------------DATI INSERITI--------------\n\n\t-msg:\t\t" << msg << "\n\t-shift:\t\t" << shift << "\n\t-lg:\t\t" << lg << "\n\n-----------------------------------------";

    //CRIPTAZIONE DEL MESSAGGIO
    if(shift > 0){
        for(int i = 0; i < lg; i++){
            index = alfabeto.find(msg[i]);
            for(int k = 0; k < shift; k++){

                index++;

                if(index == alfabeto.length() + 1) index = 0;
            }

            msg_criptato += alfabeto[index];
        }
    }else{
        for(int i = 0; i < lg; i++){
            index = alfabeto.find(msg[i]);
            for(int k = 0; k > shift; k--){
                index--;

                if(index == -1) index = alfabeto.length()-1;
            }

            msg_criptato += alfabeto[index];
        }
    }
    

    cout << "\n\n\t-messaggio criptato: " << msg_criptato << "\n\n";

    system("pause");

    return 0;
}