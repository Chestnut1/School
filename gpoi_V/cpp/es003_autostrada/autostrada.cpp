/*


PROGETTARE UN CASELLO AUTOSTRADALE


*/


#include <iostream>
#include <string>    
using namespace std;

class Veicolo{
    public:
        Veicolo() {};

        virtual double getVelocita() = 0;
        virtual string getTarga() = 0;
        virtual string toString() = 0;
        virtual int getRuote() = 0;

    private:
};

class Auto : public Veicolo{
    public:
        Auto(string targa, int nRuote, double velocita) : Veicolo() {
            this -> targa = targa;
            this -> nRoute = (nRoute >= 4 && nRoute <= 6) ? nRoute : 4;
            this -> velocita = (velocita >= 0) ? velocita : 0.0;
        }

        double getVelocita(){
            return this -> velocita;
        }

        string getTarga(){
            return this -> targa;
        }

        int getRoute(){
            return this -> nRoute;
        }

        string toString(){
            return "\n--------------\n>TARGA:\t" + this -> getTarga() + "\n>RUOTE:\t" + std::to_string(this -> getRoute()) + "\n>VELOCITA'\t" + std::to_string(this -> getVelocita()) + "\n--------------\n";
        }

    private:
        string targa;
        int nRoute;
        double velocita;

};

class Camion : public Veicolo{
    public:
        Camion(string targa, int nRuote, double velocita, int maxCarico) : Veicolo() {
            this -> targa = targa;
            this -> nRoute = (nRoute >= 4 && nRoute <= 6) ? nRoute : 4;
            this -> velocita = (velocita >= 0) ? velocita : 0.0;
            this -> maxCarico = (maxCarico > 0) ? maxCarico : 100;
        }

        double getVelocita(){
            return this -> velocita;
        }

        int getMaxCarico(){
            return this -> maxCarico;
        }

        string getTarga(){
            return this -> targa;
        }

        int getRoute(){
            return this -> nRoute;
        }

        string toString(){
            return "\n--------------\n>TARGA:\t" + this -> getTarga() + "\n>RUOTE:\t" + std::to_string(this -> getRoute()) + "\n>VELOCITA':\t" + std::to_string(this -> getVelocita()) + "\n>MAX CARICO:\t" + std::to_string(this -> getMaxCarico()) + "\n--------------\n";
        }

    private:
        string targa;
        int nRoute;
        double velocita;
        int maxCarico;

};

int main() {
    Auto panda("CN875B2", 4, 45.5);

    cout << panda.toString();

    
    return 0;
}
