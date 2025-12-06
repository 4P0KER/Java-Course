class ExceptionExamples {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация исключений ===\n");

        // 1. ArithmeticException - арифметическая ошибка
        System.out.println("1. ArithmeticException:");
        try {
            int result = 10 / 0; // Деление на ноль
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("   Ошибка: " + e.getMessage());
            System.out.println("   Деление на ноль невозможно");
        }

        // 2. ArrayIndexOutOfBoundsException - выход за границы массива
        System.out.println("\n2. ArrayIndexOutOfBoundsException:");
        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Элемент [3]: " + numbers[3]); // Индекс 3 не существует
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Ошибка: " + e.getMessage());
            System.out.println("   Индекс выходит за границы массива");
        }

        // 3. IllegalArgumentException - неверный аргумент
        System.out.println("\n3. IllegalArgumentException:");
        try {
            setAge(-5); // Передаем недопустимый возраст
        } catch (IllegalArgumentException e) {
            System.out.println("   Ошибка: " + e.getMessage());
            System.out.println("   Возраст должен быть положительным");
        }

        // 4. ClassCastException - ошибка приведения типа
        System.out.println("\n4. ClassCastException:");
        try {
            Object obj = "Это строка";
            Integer number = (Integer) obj; // Попытка привести String к Integer
            System.out.println("Число: " + number);
        } catch (ClassCastException e) {
            System.out.println("   Ошибка: " + e.getMessage());
            System.out.println("   Нельзя привести String к Integer");
        }

        // 5. NullPointerException - обращение к null ссылке
        System.out.println("\n5. NullPointerException:");
        try {
            String text = null;
            int length = text.length(); // Вызов метода у null
            System.out.println("Длина: " + length);
        } catch (NullPointerException e) {
            System.out.println("   Ошибка: " + e.getMessage());
            System.out.println("   Попытка использовать null ссылку");
        }

        // Дополнительные примеры
        System.out.println("\n=== Дополнительные примеры обработки ===");

        // Комбинированная обработка нескольких исключений
        System.out.println("\n6. Обработка нескольких исключений:");
        try {
            String str = null;
            int[] arr = new int[3];

            // Может вызвать разные исключения
            System.out.println("Длина строки: " + str.length());
            System.out.println("Элемент массива: " + arr[5]);

        } catch (NullPointerException e) {
            System.out.println("   Перехвачен NullPointerException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Перехвачен ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println("   Перехвачено общее исключение: " + e.getClass());
        } finally {
            System.out.println("   Блок finally выполняется всегда");
        }

        // Пример с созданием собственного исключения
        System.out.println("\n7. Создание исключения:");
        try {
            processNumber(101); // Вызовет исключение
        } catch (IllegalArgumentException e) {
            System.out.println("   Перехвачено: " + e.getMessage());
        }

        // Пример безопасного кода
        System.out.println("\n8. Безопасная альтернатива:");
        safeArrayAccess();
        safeNullCheck();
    }

    // Метод, который выбрасывает IllegalArgumentException
    private static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным: " + age);
        }
        System.out.println("Возраст установлен: " + age);
    }

    // Метод с проверкой аргумента
    private static void processNumber(int number) {
        if (number < 0 || number > 100) {
            throw new IllegalArgumentException("Число должно быть от 0 до 100: " + number);
        }
        System.out.println("Обработка числа: " + number);
    }

    // Безопасный доступ к массиву
    private static void safeArrayAccess() {
        int[] numbers = {1, 2, 3};
        int index = 2;

        // Проверка перед доступом
        if (index >= 0 && index < numbers.length) {
            System.out.println("Безопасный доступ: numbers[" + index + "] = " + numbers[index]);
        } else {
            System.out.println("Индекс " + index + " вне границ массива");
        }
    }

    // Безопасная проверка на null
    private static void safeNullCheck() {
        String text = null;

        // Проверка перед вызовом метода
        if (text != null) {
            System.out.println("Длина строки: " + text.length());
        } else {
            System.out.println("Строка равна null");
        }

        // Использование Optional (Java 8+)
        java.util.Optional<String> optionalText = java.util.Optional.ofNullable(text);
        System.out.println("Длина через Optional: " + optionalText.map(String::length).orElse(0));
    }
}