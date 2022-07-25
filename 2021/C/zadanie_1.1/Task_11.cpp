#include <valarray>
#include <iostream>

using namespace std;

int findBiggestDifference(int min, int max) {
    int output = 0;

    for (int i = min; i < max; i++) {
        int difference = abs(max - i);
        if (difference > output) {
            output = difference;
        }
    }
    return output;
}

int main() {
    setlocale(LC_CTYPE, "Polish");

    int biggestDifference = findBiggestDifference(1000, 9999);
    std::cout << "Największa różnica wynosi: " << biggestDifference << std::endl;

    return 0;
}
