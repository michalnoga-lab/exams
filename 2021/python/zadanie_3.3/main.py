import sqlite3

if __name__ == '__main__':
    connection = sqlite3.connect('my_db.db')
    connection.execute('PRAGMA foreign_keys=1')

    with connection:
        cursor = connection.cursor()

        cursor.execute('''
        create table if not exists products(
        id integer primary key autoincrement,
        name varchar (200) not null,
        quantity integer,
        price real
        )
        ''')

        all_products = (
            ('zeszyt', 160, 2),
            ('okładka', 100, 3),
            ('ołówek', 250, 1),
            ('długopis', 178, 5),
            ('pióro', 100, 12),
            ('gumka', 250, 1),
            ('piórnik', 125, 8),
            ('cyrkiel', 130, 4)
        )

        cursor.executemany('''insert into products (name, quantity, price) values (?, ?, ?)''', all_products)

        cursor.execute('''select * from products''')
        products_from_db = cursor.fetchall()
        print('**************************************************************************************')
        print(f'Wszystkie produkty z bazy:')
        [print(f"{product[1]} => {product[1]} => {product[2]}") for product in products_from_db]
        print('**************************************************************************************')

        cursor.execute('''select name from products where (price = 2 or price = 4)''')
        products_with_prices = cursor.fetchall()
        print('**************************************************************************************')
        print('Produkty z ceną 2 lub 4:')
        [print(f'{product[0]}') for product in products_with_prices]
        print('**************************************************************************************')

        cursor.execute('''select avg(price) from products where quantity in (125 , 160)''')
        avg_price = cursor.fetchone()
        print('**************************************************************************************')
        print('Średnia cen z produktów z ilościami pomiędzy 125 i 160:')
        [print(price) for price in avg_price]
        print('**************************************************************************************')

        cursor.execute('''select sum(quantity) from products where (price = 1 or price = 2)''')
        quantity_sum = cursor.fetchone()
        print('**************************************************************************************')
        print('Suma ilości produktów z ceną 1 lub 2:')
        [print(quantity) for quantity in quantity_sum]
        print('**************************************************************************************')

        cursor.execute('''select count(price) from products where price between 2 and 4''')
        price_count = cursor.fetchone()
        print('**************************************************************************************')
        print('Ilość produktów z ceną pomiędzy 2 i 4:')
        [print(price) for price in price_count]
        print('**************************************************************************************')

        cursor.execute('''drop table products''')
