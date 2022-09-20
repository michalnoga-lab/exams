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

int findSmallestDifference(int min, int max) {
    int output = max;

    for (int i = min; i <= max / 2; i++) {
        int difference = abs(max - i);
        if (difference <= output) {
            output = difference;
        }
    }
    return output;
}

int main() {
    setlocale(LC_CTYPE, "Polish");
    int min = 1000;
    int max = 9999;

    int biggestDifference = findBiggestDifference(min, max);
    cout << "Największa różnica wynosi: " << biggestDifference << " lub " << (max - biggestDifference) << endl;

    int smallestDifference = findSmallestDifference(min, max);
    cout << "Najmniejsza różnica wynosi: " << smallestDifference << " lub " << (max - smallestDifference) << endl;

    return 0;
}
