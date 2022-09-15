#include <iostream>

void calculate(int parameter) {
    if (parameter > 0) {
        std::cout << parameter << std::endl;
        calculate(parameter - 2);
        std::cout << parameter << std::endl;
    }
}


int main() {

    std::cout << "*****************************" << std::endl;
    calculate(5);
    std::cout << "*****************************" << std::endl;
    calculate(6);
    std::cout << "*****************************" << std::endl;
    calculate(7);
    std::cout << "*****************************" << std::endl;
    calculate(8);
    std::cout << "*****************************" << std::endl;

    return 0;
}