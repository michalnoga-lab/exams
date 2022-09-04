#include <string>
#include <fstream>
#include <map>

using namespace std;

int main() {
    string command;
    char argument;
    map<char, int> charsMap;

    fstream inputFile(
            R"(C:\Users\Michal\Documents\instrukcje.txt)",
            fstream::in);
    if (!inputFile) {
        perror("Error opening file");
        return 1;
    }

    while (inputFile >> command >> argument) {
        if (command == "DOPISZ") {
            if (charsMap.find(argument) != charsMap.end()) {
                charsMap[argument] = charsMap[argument] + 1;
            } else {
                charsMap[argument] = 1;
            }
        }
    }

    inputFile.close();

    int maxFrequency = 0;
    char mostFrequentElement;
    for (auto pair: charsMap) {
        if (pair.second > maxFrequency) {
            mostFrequentElement = pair.first;
            maxFrequency=pair.second;
        }
    }

    ofstream output;
    output.open(R"(C:\Users\Michal\Documents\wynik4.txt)");
    output << mostFrequentElement << " - " << maxFrequency << endl;
    output.close();

    return 0;
}