import java.util.StringJoiner;

class StringJoinerExample {
    public static void main(String[] args) {

        // Пример 1: Простое объединение с разделителем
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("Яблоко");
        joiner1.add("Банан");
        joiner1.add("Апельсин");
        System.out.println("1. Фрукты: " + joiner1.toString());

        // Пример 2: С префиксом и суффиксом
        StringJoiner joiner2 = new StringJoiner(" | ", "[ ", " ]");
        joiner2.add("Красный");
        joiner2.add("Зеленый");
        joiner2.add("Синий");
        System.out.println("2. Цвета: " + joiner2.toString());

        // Пример 3: Пустой StringJoiner с дефолтным значением
        StringJoiner joiner3 = new StringJoiner(", ", "Список: ", ".");
        // Если не добавить элементы, будет пустая строка
        System.out.println("3. Пустой: '" + joiner3.toString() + "'");

        joiner3.add("Первый");
        System.out.println("4. С одним элементом: " + joiner3.toString());

        // Пример 4: Объединение StringJoiner (merge)
        StringJoiner joiner4 = new StringJoiner("-", "(", ")");
        joiner4.add("A");
        joiner4.add("B");

        StringJoiner joiner5 = new StringJoiner("*", "{", "}");
        joiner5.add("C");
        joiner5.add("D");

        // merge добавляет элементы из joiner5 без префикса/суффикса
        joiner4.merge(joiner5);
        System.out.println("5. После merge: " + joiner4.toString());

        // Пример 5: Использование в цикле
        StringJoiner joiner6 = new StringJoiner(" -> ", "Маршрут: ", " -> Конец");
        String[] cities = {"Москва", "Санкт-Петербург", "Казань"};

        for (String city : cities) {
            joiner6.add(city);
        }
        System.out.println("6. " + joiner6.toString());

        // Пример 6: Методы setEmptyValue и length
        StringJoiner joiner7 = new StringJoiner(",");
        joiner7.setEmptyValue("Список пуст"); // Значение для пустого StringJoiner

        System.out.println("7. Длина (пустой): " + joiner7.length());
        System.out.println("8. Пустой joiner: " + joiner7.toString());

        joiner7.add("Элемент 1");
        System.out.println("9. Длина (после добавления): " + joiner7.length());

        // Пример 7: Использование с коллекциями (альтернатива String.join)
        StringJoiner joiner8 = new StringJoiner("\n", "Студенты:\n", "\n--- Конец списка ---");
        joiner8.add("Анна Петрова");
        joiner8.add("Иван Сидоров");
        joiner8.add("Мария Иванова");

        System.out.println("10. " + joiner8.toString());
    }
}