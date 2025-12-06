class StringMethodsDemo {
    public static void main(String[] args) {
        String text = "  Hello, Java World!  ";
        String anotherText = "hello, java world!";
        String numbers = "12345";

        // 1. length() - возвращает длину строки
        System.out.println("1. Длина строки: " + text.length());

        // 2. trim() - удаляет пробелы в начале и конце строки
        String trimmed = text.trim();
        System.out.println("2. После trim: '" + trimmed + "'");

        // 3. toUpperCase() - преобразует все символы в верхний регистр
        System.out.println("3. В верхнем регистре: " + trimmed.toUpperCase());

        // 4. toLowerCase() - преобразует все символы в нижний регистр
        System.out.println("4. В нижнем регистре: " + trimmed.toLowerCase());

        // 5. equals() - сравнивает строки с учетом регистра
        boolean isEqual = trimmed.equals(anotherText);
        System.out.println("5. equals (с регистром): " + isEqual);

        // 6. equalsIgnoreCase() - сравнивает строки без учета регистра
        boolean isEqualIgnoreCase = trimmed.equalsIgnoreCase(anotherText);
        System.out.println("6. equalsIgnoreCase: " + isEqualIgnoreCase);

        // 7. substring() - возвращает часть строки
        String substring = trimmed.substring(7, 11); // символы с 7 по 10
        System.out.println("7. substring(7, 11): " + substring);

        // 8. charAt() - возвращает символ по указанному индексу
        char firstChar = trimmed.charAt(0);
        System.out.println("8. Первый символ: " + firstChar);

        // 9. contains() - проверяет, содержит ли строка подстроку
        boolean containsJava = trimmed.contains("Java");
        System.out.println("9. Содержит 'Java': " + containsJava);

        // 10. replace() - заменяет все вхождения подстроки
        String replaced = trimmed.replace("World", "Programming");
        System.out.println("10. После replace: " + replaced);

        // Дополнительные методы для демонстрации
        // 11. startsWith() - проверяет, начинается ли строка с указанной подстроки
        System.out.println("11. Начинается с 'Hello': " + trimmed.startsWith("Hello"));

        // 12. endsWith() - проверяет, заканчивается ли строка указанной подстрокой
        System.out.println("12. Заканчивается на '!': " + trimmed.endsWith("!"));

        // 13. split() - разбивает строку на массив подстрок
        String[] words = trimmed.split(", ");
        System.out.println("13. Разделенная строка: " + words[0] + " и " + words[1]);

        // 14. parseInt() преобразование строки в число (через Integer)
        int num = Integer.parseInt(numbers);
        System.out.println("14. Строка как число: " + (num + 100));
    }
}