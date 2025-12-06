class BreakContinueCombined {
    public static void main(String[] args) {
        String[] data = {"10", "abc", "25", "error", "30", "stop", "40", "50"};

        System.out.println("Обработка данных:");
        int sum = 0;

        for (String item : data) {
            // Если встретили "stop" - прекращаем обработку
            if (item.equals("stop")) {
                System.out.println("Встречено стоп-слово, прекращаем обработку");
                break;
            }

            // Пропускаем нечисловые данные
            if (!item.matches("\\d+")) {  // Если не состоит из цифр
                System.out.println("Пропускаем невалидные данные: " + item);
                continue;
            }

            int value = Integer.parseInt(item);
            sum += value;
            System.out.println("Добавили значение: " + value);
        }

        System.out.println("Итоговая сумма: " + sum);
        // Вывод: 10 + 25 + 30 = 65
    }
}