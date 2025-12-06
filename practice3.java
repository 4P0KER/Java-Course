// ReaderWriterExample.java
import java.io.*;

class ReaderWriterExample {
    public static void main(String[] args) throws IOException {
        String text = "Привет мир!";

        // InputStream/OutputStream работают с байтами
        byte[] bytes = text.getBytes("UTF-8");
        System.out.println("Байты: " + bytes.length); // 20 байт для русского текста

        // Reader/Writer работают с символами
        System.out.println("Символы: " + text.length()); // 10 символов

        // Reader корректно читает многобайтовые символы
        try (Reader reader = new StringReader(text)) {
            int charData;
            System.out.print("Символы: ");
            while ((charData = reader.read()) != -1) {
                System.out.print((char) charData);
            }
        }
    }
}