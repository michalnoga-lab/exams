def calculate(n: int, x: int, t: [int]) -> None:
    t.append(x)
    s = n
    while int(s / 2) >= 1 and t[s] > t[int(s / 2) - 1]:
        t[s], t[int(s / 2) - 1] = t[int(s / 2) - 1], t[s]
        s = int(s / 2)
    print(f'Tablica po przekształceniu: {t}')


if __name__ == '__main__':
    calculate(4, 5, [26, 3, 5, -4])
    calculate(4, -5, [36, 15, 17, 3])
