#include <iostream>
#include <valarray>

using namespace std;

int convertFromBinary(const string &binary) {
    int power = 0;
    int output = 0;
    int index = (int) binary.size() - 1;

    while (index >= 0) {
        if (binary[index] == '1') {
            output += (int) pow(2, power);
        }
        index--;
        power++;
    }
    return output;
}

int convertFromHex(const string &hex) {
    int length = hex.size();
    int power = 0;
    int output = 0;

    for (int i = length - 1; i >= 0; i--) {
        if (hex[i] <= '9') {
            output += (int) ((hex[i] - 48) * pow(16, power));
        } else if (hex[i] >= 'A' && hex[i] <= 'F') {
            output += (int) ((hex[i] - 55) * pow(16, power));
        }
        power++;
    }
    return output;
}

int convertFromFour(const string &four) {
    int length = four.size();
    int power = 0;
    int output = 0;

    for (int i = length - 1; i >= 0; i--) {
        output += (int) ((four[i] - 48) * pow(4, power));
        power++;
    }
    return output;
}

int convertFromOctet(const string &octet) {
    int length = octet.size();
    int power = 0;
    int output = 0;

    for (int i = length - 1; i >= 0; i--) {
        output += (int) ((octet[i] - 48) * pow(8, power));
        power++;
    }
    return output;
}


int main() {

    cout << "********************************************************************************" << endl;
    cout << "Decimal vale from binary 10000000 is " << convertFromBinary("10000000") << endl;
    cout << "Decimal value from hexadecimal A9 is " << convertFromHex("A9") << endl;
    cout << (convertFromBinary("10000000") > convertFromHex("A9")) << endl;
    cout << "********************************************************************************" << endl;
    cout << "Decimal value from four system 1111 is " << convertFromFour("1111") << endl;
    cout << "Decimal value from binary 1111111 is " << convertFromBinary("1111111") << endl;
    cout << (convertFromFour("1111") > convertFromBinary("1111111")) << endl;
    cout << "********************************************************************************" << endl;
    cout << "Decimal value from four system 3003 is " << convertFromFour("3003") << endl;
    cout << "Decimal value from hexadecimal C2 is " << convertFromHex("C2") << endl;
    cout << (convertFromFour("3003") > convertFromHex("C2")) << endl;
    cout << "********************************************************************************" << endl;
    cout << "Decimal value from binary 10100101 is " << convertFromBinary("10100101") << endl;
    cout << "Decimal value from octet 333 is " << convertFromOctet("333") << endl;
    cout << (convertFromOctet("333") > convertFromBinary("10100101")) << endl;
    cout << "********************************************************************************" << endl;

    return 0;
}