class BufferBuilderDemo {
    public static void main(String[] args) {

        // Демонстрация методов StringBuilder (несинхронизированный, быстрее)
        System.out.println("StringBuilder методы");
        StringBuilder sb = new StringBuilder("Hello");

        // 1. append() - добавляет строку в конец
        sb.append(" World");
        System.out.println("1. append: " + sb.toString());

        // 2. insert() - вставляет строку в указанную позицию
        sb.insert(5, ", Java");
        System.out.println("2. insert: " + sb.toString());

        // 3. delete() - удаляет символы с start до end-1
        sb.delete(5, 11); // Удаляем ", Java"
        System.out.println("3. delete: " + sb.toString());

        // 4. reverse() - переворачивает строку
        StringBuilder reversed = new StringBuilder(sb).reverse();
        System.out.println("4. reverse: " + reversed.toString());

        // 5. replace() - заменяет символы с start до end-1
        sb.replace(6, 11, "Universe");
        System.out.println("5. replace: " + sb.toString());

        // 6. charAt() - возвращает символ по индексу
        char ch = sb.charAt(0);
        System.out.println("6. charAt(0): " + ch);

        // 7. setCharAt() - заменяет символ по индексу
        sb.setCharAt(0, 'h');
        System.out.println("7. setCharAt: " + sb.toString());

        // 8. capacity() - возвращает текущую емкость
        System.out.println("8. capacity: " + sb.capacity());

        // 9. ensureCapacity() - гарантирует минимальную емкость
        sb.ensureCapacity(50);
        System.out.println("9. capacity после ensureCapacity: " + sb.capacity());

        // 10. substring() - возвращает подстроку
        String sub = sb.substring(6, 14);
        System.out.println("10. substring(6, 14): " + sub);

        System.out.println("\nStringBuffer методы (синхронизированный)");

        // Демонстрация методов StringBuffer (синхронизированный, потокобезопасный)
        StringBuffer buffer = new StringBuffer("Пример");

        // 11. length() - возвращает длину строки
        System.out.println("11. length: " + buffer.length());

        // 12. indexOf() - ищет первое вхождение подстроки
        buffer.append(" строки StringBuffer");
        int index = buffer.indexOf("стр");
        System.out.println("12. indexOf('стр'): " + index);

        // 13. lastIndexOf() - ищет последнее вхождение
        buffer.append(" еще строка");
        int lastIndex = buffer.lastIndexOf("стр");
        System.out.println("13. lastIndexOf('стр'): " + lastIndex);

        // 14. deleteCharAt() - удаляет символ по индексу
        buffer.deleteCharAt(0);
        System.out.println("14. deleteCharAt(0): " + buffer.toString());

        // 15. setLength() - устанавливает новую длину
        buffer.setLength(10);
        System.out.println("15. setLength(10): '" + buffer.toString() + "'");

        // Восстанавливаем для следующих методов
        buffer = new StringBuffer("Тестовая строка");

        // 16. getChars() - копирует символы в массив
        char[] chars = new char[7];
        buffer.getChars(0, 7, chars, 0);
        System.out.print("16. getChars: ");
        System.out.println(chars);

        // 17. toString() - преобразует в обычную строку
        String normalString = buffer.toString();
        System.out.println("17. toString: " + normalString);

        // Сравнение производительности
        System.out.println("\nСравнение производительности");
        long startTime, endTime;

        // StringBuilder
        startTime = System.nanoTime();
        StringBuilder sbPerf = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sbPerf.append("text");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder время: " + (endTime - startTime) + " нс");

        // StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbufPerf = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            sbufPerf.append("text");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer время: " + (endTime - startTime) + " нс");
    }
}