#include <string>
#include <fstream>

using namespace std;

int main() {
    string command;
    char argument;
    int longestSequence = 0;
    string longestSequenceInstruction;
    int longestSequenceTemp = 0;
    string longestSequenceInstructionTemp;
    string previousCommand;

    fstream inputFile(
            R"(C:\Users\Michal\Documents\instrukcje.txt)",
            fstream::in);
    if (!inputFile) {
        perror("Error opening file");
        return 1;
    }

    while (inputFile >> command >> argument) {
        if (command == previousCommand) {
            longestSequenceTemp++;
            longestSequenceInstructionTemp = command;
        } else {
            if (longestSequenceTemp > longestSequence) {
                longestSequence = longestSequenceTemp;
                longestSequenceInstruction = longestSequenceInstructionTemp;
            }
            longestSequenceTemp = 1;
            longestSequenceInstructionTemp = "";
        }
        previousCommand = command;
    }

    inputFile.close();

    ofstream output;
    output.open(R"(C:\Users\Michal\Documents\wynik4.txt)");
    output << longestSequence << " - " << longestSequenceInstruction << endl;
    output.close();

    return 0;
}