import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ScannerFileExample {
    public static void main(String[] args) {
        // Создаем временный файл с данными
        String fileName = "test_data.txt";

        try {
            // Создаем файл с данными
            java.io.FileWriter writer = new java.io.FileWriter(fileName);
            writer.write("Иванов Иван 25\n");
            writer.write("Петров Петр 30\n");
            writer.write("Сидорова Анна 28\n");
            writer.close();

            System.out.println("Чтение файла с помощью Scanner:");
            System.out.println("================================");

            // Чтение файла через Scanner
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            // Чтение построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Строка: " + line);
            }

            scanner.close();

            System.out.println("\nЧтение с разбивкой на токены:");
            System.out.println("==============================");

            // Чтение с разбивкой на отдельные слова/числа
            Scanner scanner2 = new Scanner(file);
            while (scanner2.hasNext()) {
                if (scanner2.hasNextInt()) {
                    int age = scanner2.nextInt();
                    System.out.println("Возраст: " + age);
                } else {
                    String word = scanner2.next();
                    System.out.println("Слово: " + word);
                }
            }

            scanner2.close();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (java.io.IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            // Удаляем временный файл
            new File(fileName).delete();
        }
    }
}