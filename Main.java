class ExceptionHandlingDemo {
    public static void main(String[] args) {
        System.out.println("Программа демонстрации обработки исключений\n");

        // 1. Исключение, которое будет ПЕРЕХВАЧЕНО
        System.out.println("1. Исключение, которое будет ПЕРЕХВАЧЕНО:");
        try {
            int result = divideNumbers(10, 0); // Вызовет ArithmeticException
            System.out.println("Результат деления: " + result);
        } catch (ArithmeticException e) {
            System.out.println("   ✓ Исключение ПЕРЕХВАЧЕНО: " + e.getMessage());
            System.out.println("   Программа продолжает работу...\n");
        }

        // 2. Исключение, которое НЕ будет перехвачено и приведет к аварийной остановке
        System.out.println("2. Исключение, которое НЕ будет перехвачено:");

        // Этот вызов вызовет исключение, которое не будет обработано
        accessArrayElement(null, 5); // NullPointerException

        // Этот код не выполнится, так как программа аварийно остановится выше
        System.out.println("   Эта строка НИКОГДА не будет выполнена!");
    }

    // Метод, который может вызвать ArithmeticException
    private static int divideNumbers(int a, int b) {
        return a / b; // Деление на ноль вызовет исключение
    }

    // Метод, который может вызвать NullPointerException
    private static void accessArrayElement(int[] array, int index) {
        // Не проверяем array на null - может вызвать исключение
        System.out.println("   Элемент массива: " + array[index]);
    }

    // Дополнительный пример для демонстрации цепочки
    private static void demonstrateChain() {
        System.out.println("\nДополнительная демонстрация");

        // Перехваченное исключение
        try {
            String str = null;
            str.toUpperCase(); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Исключение перехвачено в demonstrateChain()");
        }

        // НЕ перехваченное исключение (остановит программу)
        int[] numbers = {1, 2, 3};
        System.out.println("Элемент: " + numbers[10]); // ArrayIndexOutOfBoundsException
    }
}

// Другой класс для демонстрации остановки между классами
class AnotherClass {
    public static void riskyMethod() {
        System.out.println("\nВызов из другого класса");

        // Это исключение не будет перехвачено
        Object obj = "строка";
        Integer num = (Integer) obj; // ClassCastException

        System.out.println("Этот код не выполнится");
    }
}