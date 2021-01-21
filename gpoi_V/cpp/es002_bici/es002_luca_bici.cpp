/*
Creare una classe Bicicletta che memorizzi per ogni bicicletta: taglia del telaio, marca e la velocità a cui sta andando.
Creare tutti i metodi opportuni della classe bicicletta, inoltre si creino:
– string toString() che restituisca una stringa con le caratteristiche della bicicletta,
ad esempio “Bicicletta: Atala telaio: 26 velocità 10 km/h”
– void stampaStato() che stampa a schermo lo stato ovvero ad esempio “velocità 10 km/h”
Nella creazione delle classi si mettano tutti gli attributi private.
Creare una classe MountainBike, ogni mountain bike è una bicicletta che ha la caratteristica specifica di possedere anche le marce, gestite da due selettori.
I valori delle marce andranno da 1 a un massimo che potrà variare da selettore a selettore e da bicicletta a bicicletta.
Creare tutti i metodi opportuni della classe bicicletta, inoltre si creino:
– string toString() che restituisca una stringa con le caratteristiche della mountain bike,
ad esempio “Mountain Bike: Atala telaio: 26 velocità 10 km/h”
– void stampaStato() che stampa a schermo lo stato ovvero ad esempio:
“velocità 10 km/h – marce selettore1: 2 – marce selettore2: 7”

*/
#include <iostream>
using namespace std;

class Bike{
    public:
        Bike(char size, string brand, float currentSpeed){
            this -> size = (size == 'S' || size == 'M' || size == 'L') ? size : 'M';
            this -> brand = brand;
            this -> currentSpeed = (currentSpeed >= 0.0) ? currentSpeed : 0.0;
        }

        void setSpeed(float speed){
            this -> currentSpeed = (speed >= 0.0) ? speed : 0.0;
        }

        string toString(){
            string out = "-BRAND:\t\t" + brand + "\n-SPEED:\t\t" + to_string(currentSpeed) + "\n-SIZE:\t\t";
            out += size;
            return out + "\n";
        }

        char getSize(){
            return size;
        }

        string getBrand(){
            return brand;
        }

        float getCurrentSpeed(){
            return currentSpeed;
        }

        void printState(){
            cout << "CURRENT SPEED: \t " + to_string(currentSpeed) + "Km/h\n";
        }

    private:
        char size;
        string brand;
        float currentSpeed;
};

class MTB : Bike{
    public:
        MTB(char size, string brand, float currentSpeed, int changeSX, int changeDX) : Bike(size, brand, currentSpeed){
            this -> changeSX = (changeSX >= 1) ? changeSX : 1;
            this -> changeDX = (changeDX >= 1) ? changeDX : 1;
        }

        string toString(){
            string out = "-BRAND:\t\t" + getBrand() + "\n-SPEED:\t\t" + to_string(getCurrentSpeed()) + "\n-SIZE:\t\t";
            out += getSize();
            return out + "\n-CHANGES (SX/DX):\t\t" + to_string(changeSX) + " | " + to_string(changeDX) + "\n";
        }

        void printState(){
            cout << "CURRENT SPEED: \t " + to_string(getCurrentSpeed()) + " Km/h\n";
        }

        

    private:
        int changeSX;
        int changeDX;
};

int main() {
    MTB myBike('M',"HaiBike",0.0,4,9);

    cout << myBike.toString();

    cout << "\n\nstato attuale:\n";
    myBike.printState();
    
    return 0;
}