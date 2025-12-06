// FileInputStreamExample.java
import java.io.*;

class FileInputStreamExample {
    public static void main(String[] args) throws IOException {
        // Создаем временный файл с текстом
        File file = new File("test.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("ABC");
        }

        // Читаем файл по одному байту
        try (InputStream input = new FileInputStream(file)) {
            int byteData;
            System.out.print("Байты: ");

            while ((byteData = input.read()) != -1) {
                System.out.print(byteData + " "); // 65 66 67
            }
        }

        // Удаляем временный файл
        file.delete();
    }
}