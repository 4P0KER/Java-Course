// FileOutputStreamExample.java
import java.io.*;

class FileOutputStreamExample {
    public static void main(String[] args) throws IOException {
        // Записываем отдельные байты в файл
        try (OutputStream output = new FileOutputStream("output.bin")) {
            output.write(65);  // 'A'
            output.write(66);  // 'B'
            output.write(67);  // 'C'
        }

        System.out.println("Файл создан с байтами: 65, 66, 67");

        // Удаляем файл
        new File("output.bin").delete();
    }
}