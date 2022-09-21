#include <iostream>
#include <fstream>

using namespace std;

string add(string text, const char &ch) {
    return text + ch;
}

string remove(string text, const char &ch) {
    text.pop_back();
    return text;
}

string change(string text, const char &ch) {
    text[text.length() - 1] = ch;
    return text;
}

string move(string text, const char &ch) {
    int charIndex = text.find(ch);

    if (charIndex != -1) {
        if (text[charIndex] >= 90) {
            text[charIndex] = 65;
        } else {
            text[charIndex] = text[charIndex] + 1;
        }
    }
    return text;
}

int main() {

    string command;
    char argument;

    fstream input(
            R"(C:\Users\Michal\Documents\instrukcje.txt)",
            fstream::in);
    string finalSentence;

    if (!input) {
        perror("Error opening file!");
        return 1;
    }

    while (input >> command >> argument) {

        if (command == "DOPISZ") {
            finalSentence = add(finalSentence, argument);
        } else if (command == "USUN") {
            finalSentence = remove(finalSentence, argument);
        } else if (command == "ZMIEN") {
            finalSentence = change(finalSentence, argument);
        } else if (command == "PRZESUN") {
            finalSentence = move(finalSentence, argument);
        }
    }

    input.close();

    ofstream output;
    output.open(R"(C:\Users\Michal\Documents\wynik4.txt)");
    output << finalSentence;
    output.close();

    return 0;
}