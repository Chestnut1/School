
#include <iostream>
using namespace std;

template <class T>
class Calculator{
    T a, b;
    public:
    Calculator (T first, T second){a=first; b=second;}
    T sum();
    T sub();
    T div();
    T mul();
};

template <class T>
T Calculator<T>::sum(){
    return a+b;
}

template <class T>
T Calculator<T>::sub(){
    return a-b;
}

template <class T>
T Calculator<T>::div(){
    return a/b;
    }

template <class T>
T Calculator<T>::mul(){
    return a*b;
}

int main () {
    Calculator <int> calc_int (100, 75);
    Calculator <float> calc_float (80.52, 75.34);
    cout << "INT: sum - sub - div - mul" << endl;
    cout << calc_int.sum() << endl;
    cout << calc_int.sub() << endl;
    cout << calc_int.div() << endl;
    cout << calc_int.mul() << endl;
    cout << "FLOAT: sum - sub - div - mul" << endl;
    cout << calc_float.sum() << endl;
    cout << calc_float.sub() << endl;
    cout << calc_float.div() << endl;
    cout << calc_float.mul() << endl;
    return 0;
}
