import java.io.*;

// Создаем иерархию исключений
class Ex1 extends Exception {
    public Ex1(String message) { super(message); }
}

class Ex2 extends Ex1 {
    public Ex2(String message) { super(message); }
}

class Ex3 extends Ex2 {
    public Ex3(String message) { super(message); }
}

class ExceptionHierarchyDemo {
    public static void main(String[] args) {
        System.out.println("=== Ситуация 1: Идентичная обработка нескольких исключений ===\n");

        // 1. Обработка разных исключений одинаковым способом
        try {
            methodWithMultipleExceptions();
        }
        // Множественный catch для разных исключений с одинаковой обработкой
        catch (ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("✓ Общая обработка для: " + e.getClass().getSimpleName());
            System.out.println("  Сообщение: " + e.getMessage());
            System.out.println("  Действие: Логируем и продолжаем работу\n");
        }

        System.out.println("=== Ситуация 2: Обработка иерархии исключений ===\n");

        // 2. Обработка иерархии исключений Ex1 <|-- Ex2 <|-- Ex3
        System.out.println("Тест 1: Генерация Ex3 (самого специфичного):");
        testException(new Ex3("Ошибка типа Ex3"));

        System.out.println("\nТест 2: Генерация Ex2 (среднего уровня):");
        testException(new Ex2("Ошибка типа Ex2"));

        System.out.println("\nТест 3: Генерация Ex1 (самого общего):");
        testException(new Ex1("Ошибка типа Ex1"));

        System.out.println("\n=== Важный момент с порядком catch ===");

        // Демонстрация правильного и неправильного порядка catch
        try {
            throw new Ex3("Тест порядка catch");
        } catch (Ex3 e) {
            System.out.println("✓ Правильно: Сначала Ex3, потом Ex1");
        } catch (Ex1 e) {
            System.out.println("✗ Этот блок не выполнится для Ex3");
        }

        // Неправильный порядок (не скомпилируется)
        /*
        try {
            throw new Ex3("Тест");
        } catch (Ex1 e) {  // Будет перехватывать ВСЕ исключения иерархии
            System.out.println("Перехвачено Ex1");
        } catch (Ex3 e) {  // Этот блок НЕДОСТИЖИМ - ошибка компиляции
            System.out.println("Недостижимый код");
        }
        */
    }

    // Метод, который может выбросить разные исключения
    private static void methodWithMultipleExceptions() throws
            ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException {

        int scenario = (int)(Math.random() * 3); // Случайный выбор

        switch(scenario) {
            case 0:
                throw new ArithmeticException("Деление на ноль");
            case 1:
                throw new NullPointerException("Объект не инициализирован");
            case 2:
                throw new ArrayIndexOutOfBoundsException("Индекс вне границ массива");
        }
    }

    // Метод для демонстрации обработки иерархии исключений
    private static void testException(Exception ex) {
        try {
            // Симулируем выброс переданного исключения
            throw ex;
        }
        catch (Ex3 e) {
            // Обработка самого специфичного исключения
            System.out.println("  Перехвачено Ex3: " + e.getMessage());
            System.out.println("  Действие: Специфичная обработка для Ex3");
        }
        catch (Ex2 e) {
            // Обработка исключения среднего уровня
            System.out.println("  Перехвачено Ex2: " + e.getMessage());
            System.out.println("  Действие: Обработка для Ex2 и его подклассов");
        }
        catch (Ex1 e) {
            // Обработка самого общего исключения в иерархии
            System.out.println("  Перехвачено Ex1: " + e.getMessage());
            System.out.println("  Действие: Общая обработка для всей иерархии");
        }
        catch (Exception e) {
            // Обработка любых других исключений
            System.out.println("  Перехвачено общее исключение: " + e.getMessage());
        }
    }

    // Дополнительный пример с практической иерархией
    private static void practicalExample() {
        System.out.println("\n=== Практический пример с IOException ===");

        try {
            // Может выбросить разные исключения из иерархии IOException
            readFile();
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
        catch (EOFException e) {
            System.out.println("Неожиданный конец файла: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Общая ошибка ввода-вывода: " + e.getMessage());
        }
    }

    private static void readFile() throws IOException {
        // Симуляция разных ошибок
        double random = Math.random();

        if (random < 0.33) {
            throw new FileNotFoundException("файл.txt не существует");
        } else if (random < 0.66) {
            throw new EOFException("Достигнут конец файла");
        } else {
            throw new IOException("Неизвестная ошибка IO");
        }
    }
}