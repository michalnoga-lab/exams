#include <valarray>
#include <iostream>

int findNumberComplement(int inputNumber) {
    int baseNumber = inputNumber;
    int array[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int complement = 0;
    int counter = 0;

    while (baseNumber > 0) {
        int lastDigit = baseNumber % 10;

        array[counter] = abs(9 - lastDigit);
        baseNumber = baseNumber / 10;
        counter++;
    }

    for (int i = 0; i < sizeof(array) / sizeof(array[0]); i++) {
        complement = int(complement + array[i] * pow(10, i));
    }

    return complement;
}

int main() {

    int number1 = 123;
    int complement1 = findNumberComplement(number1);
    std::cout << "Dopełnieniem liczby " << number1 << " jest liczba " << complement1 << std::endl;

    int number2 = 231;
    int complement2 = findNumberComplement(number2);
    std::cout << "Dopełenieniem liczby " << number2 << " jest liczba " << complement2 << std::endl;

    int number3 = 987654321;
    int complement3 = findNumberComplement(number3);
    std::cout << "Dopełenieniem liczby " << number3 << " jest liczba " << complement3 << std::endl;

    return 0;
}