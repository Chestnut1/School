
#include <iostream>
using namespace std;

template <class T>
class Calcolatrice {
    T a,b;
    public:
        Calcolatrice(T a, T b){
            this -> a = a;
            this -> b = b;
        }

        T sum();
        T div();
        T mul();
        T sub();
};

template <class T>
T Calcolatrice<T>::sum(){
    return a + b;
}

template <class T>
T Calcolatrice<T>::sub(){
    return a - b;
}

template <class T>
T Calcolatrice<T>::mul(){
    return a * b;
}

template <class T>
T Calcolatrice<T>::div(){
    return a / b;
}

int main(){

    Calcolatrice <int> c1(2532,8326);
    Calcolatrice <float> c2(64181.5,5718094.98);

    cout << "[c1]\n> sum:\t" + std::to_string(c1.sum()) + "\n> sub:\t" + std::to_string(c1.sub()) + "\n> mul:\t" + std::to_string(c1.mul()) + "\n> div:\t" + std::to_string(c1.div()) + "\n\n";

    cout << "[c2]\n> sum:\t" + std::to_string(c2.sum()) + "\n> sub:\t" + std::to_string(c2.sub()) + "\n> mul:\t" + std::to_string(c2.mul()) + "\n> div:\t" + std::to_string(c2.div()) + "\n\n";

    return 0;
}
