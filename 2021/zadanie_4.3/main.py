import collections
from typing import List


def get_instructions() -> List[str]:
    output: List[str] = []
    with open('instrukcje.txt') as file:
        file_content: List[str] = file.read().split('\n')
    [output.append(line.split(' ')[1]) for line in file_content if line.split(' ')[0] == 'DOPISZ']
    return output


def write_output(output: str) -> None:
    with open('wyniki4.txt', 'w') as file:
        file.write(output)


if __name__ == '__main__':
    frequencies = collections.Counter(get_instructions())
    most_frequent = frequencies.most_common()[0]

    write_output(f'Najczęściej dopisywaną literą była litera {most_frequent[0]}, {most_frequent[1]} razy')
