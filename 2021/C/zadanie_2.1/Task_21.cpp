#include <iostream>
#include <algorithm>

void calculate(int array[], int n, int x) {
    n++;
    int extendedArray[n];

    for (int i = 0; i < n; i++) {
        extendedArray[i] = array[i];
    }

    extendedArray[n - 1] = x;
    int s = n;

    while ((s / 2 >= 1) && extendedArray[s] > extendedArray[s / 2]) {
        int temp = extendedArray[s];
        extendedArray[s] = extendedArray[s / 2];
        extendedArray[s / 2] = temp;
        s = s / 2;
    }

    int arraySize = sizeof(extendedArray) / sizeof(extendedArray[0]);

    for (int i = 0; i < arraySize; i++) {
        std::cout << extendedArray[i] << std::endl;
    }
}

void print(const int &i) {
    std::cout << i << ' ';
}

int main() {

    int array1[4] = {26, 3, 5, -4};
    std::cout << "Dla tablicy " << std::flush;
    std::for_each(std::begin(array1), std::end(array1), print);
    std::cout << " otrzymamy po przekształceniu tablicę " << std::flush;
    calculate(array1, 4, 5);

    return 0;
}