class FormatSpecifiersDemo {
    public static void main(String[] args) {

        // Пример 1: %s - строковое представление
        String name = "Анна";
        int age = 25;
        System.out.printf("1. %%s: Привет, %s!%n", name);

        // Пример 2: %d - десятичное целое число
        int quantity = 15;
        double price = 299.99;
        System.out.printf("2. %%d: Количество товаров: %d шт.%n", quantity);

        // Пример 3: %f - десятичное число с плавающей точкой
        System.out.printf("3. %%f: Цена товара: %.2f руб.%n", price);
        // %.2f - 2 знака после запятой

        // Пример 4: %b - логическое значение
        boolean isAvailable = true;
        boolean hasDiscount = false;
        System.out.printf("4. %%b: Товар в наличии: %b%n", isAvailable);
        System.out.printf("   Скидка доступна: %b%n", hasDiscount);

        // Пример 5: %c - символьное представление
        char grade = 'A';
        char currency = '₽';
        System.out.printf("5. %%c: Оценка: %c, Валюта: %c%n", grade, currency);

        // Дополнительные примеры:

        // Пример 6: %n - вставка новой строки
        System.out.printf("6. %%n: Первая строка%nВторая строка%n");

        // Пример 7: %% - вывод знака процента
        double discount = 15.5;
        System.out.printf("7. %%%. Скидка: %.1f%%%n", discount);

        // Пример 8: Комбинированное использование
        System.out.printf("%n8. Комбинированный пример:%n");
        System.out.printf("Покупатель: %s, возраст: %d%n", name, age);
        System.out.printf("Сумма к оплате: %.2f%c%n", price, currency);
        System.out.printf("Скидка %.1f%% применена: %b%n", discount, hasDiscount);

        // Пример 9: Использование ширины поля
        String[] products = {"Яблоки", "Бананы", "Апельсины"};
        double[] prices = {89.90, 120.50, 150.75};

        System.out.printf("%n9. Форматированная таблица:%n");
        System.out.printf("%-15s %10s%n", "Товар", "Цена");
        System.out.println("-".repeat(25));

        for (int i = 0; i < products.length; i++) {
            // %-15s - выравнивание по левому краю, ширина 15 символов
            // %10.2f - выравнивание по правому краю, ширина 10, 2 знака после запятой
            System.out.printf("%-15s %10.2f руб.%n", products[i], prices[i]);
        }

        // Пример 10: %h - хэш-код объекта
        System.out.printf("%n10. %%h: Хэш-код строки '%s': %h%n", name, name.hashCode());
    }
}