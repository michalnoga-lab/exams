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
    longest_sequence: int = 0
    longest_sequence_instruction: str = ''
    temp_longest_sequence: int = 0
    temp_longest_sequence_instruction = ''

    for idx, instruction in enumerate(instructions):
        if idx < len(instructions) - 1:
            current_instruction: str = instructions[idx].split(' ')[0]
            i: int = 1
            while current_instruction == instructions[idx + i].split(' ')[0]:
                i += 1
                temp_longest_sequence = i
                temp_longest_sequence_instruction = instruction.split(' ')[0]
            if temp_longest_sequence > longest_sequence:
                longest_sequence = temp_longest_sequence
                longest_sequence_instruction = temp_longest_sequence_instruction
            temp_longest_sequence = 0
            temp_longest_sequence_instruction = ''
            if idx + i < len(instructions):
                idx += i
            else:
                break

    write_output(
        f'Najczęstszą instrukcją jest {longest_sequence_instruction}, która wystąpiła {longest_sequence} razy z rzędu')
