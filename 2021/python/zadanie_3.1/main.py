def calculate(n: int) -> None:
    if n > 0:
        print(n)
        calculate(n - 2)
        print(n)


if __name__ == '__main__':
    print('********************************')
    calculate(5)
    print('********************************')
    calculate(6)
    print('********************************')
    calculate(7)
    print('********************************')
    calculate(8)
    print('********************************')
