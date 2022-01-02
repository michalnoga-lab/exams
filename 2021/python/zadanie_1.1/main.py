def get_complement(number: int) -> int:
    complement: str = ''
    for digit in str(number):
        complement += str(9 - int(digit))
    return int(complement)


def get_difference(first: int, second: int) -> int:
    return abs(first - second)


if __name__ == '__main__':
    all_four_digit_numbers = [number for number in range(1000, 10000)]
    all_complements = [(number, get_complement(number), get_difference(number, get_complement(number))) for number in
                       all_four_digit_numbers if number <= 5000]
    biggest_difference = sorted(all_complements, key=lambda value: value[2], reverse=True)[0]
    smallest_difference = sorted(all_complements, key=lambda value: value[2])[0]

    print(f'Najmniejsza różnica jest dla liczb: {smallest_difference[0]} oraz '
          f'{smallest_difference[1]} i wynosi: {smallest_difference[2]}')
    print(f'Największa różnica jest dla liczb: {biggest_difference[0]} oraz '
          f'{biggest_difference[1]} i wynosi :{biggest_difference[2]}')

