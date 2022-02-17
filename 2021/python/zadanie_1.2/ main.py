def get_digit_complement(digit: int) -> int:
    return 9 - digit


class DigitComplement:
    def __init__(self, number: int):
        self.number = number
        self.ten_power = 0
        self.complement = 0

    def calculate_complement(self) -> tuple:
        temp_number = self.number

        while temp_number >= 1:
            last_digit = temp_number % 10
            last_digit_complement = get_digit_complement(last_digit)

            self.complement += last_digit_complement * 10 ** self.ten_power
            self.ten_power += 1
            temp_number = int(temp_number / 10)
        return self.number, self.complement


if __name__ == '__main__':
    complement_1 = DigitComplement(123)
    result = complement_1.calculate_complement()
    print(f'Dopełnieniem liczby {result[0]} jest liczba {result[1]}')

    complement_2 = DigitComplement(231)
    result = complement_2.calculate_complement()
    print(f'Dopełnieniem liczby {result[0]} jest liczba {result[1]}')

    complement_3 = DigitComplement(987654321123456789)
    result = complement_3.calculate_complement()
    print(f'Dopełnieniem liczby {result[0]} jest liczba {result[1]}')
