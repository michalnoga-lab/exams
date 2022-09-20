#include <iostream>

using namespace std;

void calculate(int parameter) {
    if (parameter > 0) {
        std::cout << parameter << std::endl;
        calculate(parameter - 2);
        std::cout << parameter << std::endl;
    }
}


int main() {

    cout << "*****************************" << endl;
    calculate(5);
    cout << "*****************************" << endl;
    calculate(6);
    cout << "*****************************" << endl;
    calculate(7);
    cout << "*****************************" << endl;
    calculate(8);
    cout << "*****************************" << endl;

    return 0;
}