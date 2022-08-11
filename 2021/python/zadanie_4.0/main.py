from typing import List


def get_instructions() -> List[str]:
    with open('instrukcje.txt') as file:
        output = file.read().split('\n')

    return output


def write_output(output: str) -> None:
    with open('wyniki4.txt', 'w') as file:
        file.write(output)


if __name__ == '__main__':
    sentence: List[str] = []
    instructions: List[str] = get_instructions()

    for instruction in instructions:
        temp_instruction: List[str] = instruction.split(' ')

        if temp_instruction[0] == 'DOPISZ':
            sentence.append(temp_instruction[1])
        elif temp_instruction[0] == 'ZMIEN':
            sentence = sentence[0:len(sentence) - 1]
            sentence.append(temp_instruction[1])
        elif temp_instruction[0] == 'USUN':
            sentence = sentence[0:len(sentence) - 1]
        elif temp_instruction[0] == 'PRZESUN':
            idx: int = 0
            while idx < len(sentence):
                if sentence[idx] == temp_instruction[1]:
                    current_character: ord = temp_instruction[1]
                    if ord(current_character) == 90:
                        next_letter = 'A'
                    else:
                        next_letter = chr(ord(current_character) + 1)
                    sentence[idx] = next_letter
                    idx += len(sentence)
                idx += 1

    write_output("".join(sentence))
