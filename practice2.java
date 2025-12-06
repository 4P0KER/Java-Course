class StringConversion {
    public static void main(String[] args) {

        System.out.println("1. String → StringBuilder/StringBuffer");

        // String в StringBuilder
        String str = "Исходная строка";
        StringBuilder sbFromString = new StringBuilder(str); // Конструктор
        System.out.println("String → StringBuilder: " + sbFromString);

        // String в StringBuffer
        StringBuffer sBufFromString = new StringBuffer(str); // Конструктор
        System.out.println("String → StringBuffer: " + sBufFromString);

        System.out.println("\n2. StringBuilder → String");

        // StringBuilder в String
        StringBuilder sb = new StringBuilder("StringBuilder текст");

        // Способ 1: toString() - основной метод
        String strFromSB1 = sb.toString();
        System.out.println("StringBuilder.toString(): " + strFromSB1);

        // Способ 2: через конкатенацию (неявный toString())
        String strFromSB2 = "" + sb;
        System.out.println("Через конкатенацию: " + strFromSB2);

        // Способ 3: valueOf()
        String strFromSB3 = String.valueOf(sb);
        System.out.println("String.valueOf(): " + strFromSB3);

        System.out.println("\n3. StringBuffer → String");

        // StringBuffer в String
        StringBuffer sBuf = new StringBuffer("StringBuffer текст");

        // Способ 1: toString() - основной метод
        String strFromSBuf1 = sBuf.toString();
        System.out.println("StringBuffer.toString(): " + strFromSBuf1);

        // Способ 2: substring() - если нужна часть строки
        String strFromSBuf2 = sBuf.substring(0); // вся строка
        System.out.println("substring(0): " + strFromSBuf2);

        String strFromSBuf3 = sBuf.substring(0, 11); // часть строки
        System.out.println("substring(0, 11): " + strFromSBuf3);

        System.out.println("\n4. StringBuilder ↔ StringBuffer");

        // StringBuilder → StringBuffer (через String)
        StringBuilder sb2 = new StringBuilder("Текст StringBuilder");
        StringBuffer sBuf2 = new StringBuffer(sb2.toString()); // Через String
        System.out.println("StringBuilder → StringBuffer: " + sBuf2);

        // StringBuffer → StringBuilder (через String)
        StringBuffer sBuf3 = new StringBuffer("Текст StringBuffer");
        StringBuilder sb3 = new StringBuilder(sBuf3.toString()); // Через String
        System.out.println("StringBuffer → StringBuilder: " + sb3);

        System.out.println("\n5. Дополнительные преобразования");

        // Метод append() для преобразования
        StringBuilder sb4 = new StringBuilder();
        StringBuffer sBuf4 = new StringBuffer();

        // Append принимает любой объект (вызывает его toString())
        sb4.append(sBuf3); // StringBuffer в StringBuilder через append
        sBuf4.append(sb2); // StringBuilder в StringBuffer через append

        System.out.println("StringBuffer → StringBuilder через append: " + sb4);
        System.out.println("StringBuilder → StringBuffer через append: " + sBuf4);

        System.out.println("\n6. Преобразование с изменением содержимого");

        String immutable = "Hello";
        StringBuilder mutable = new StringBuilder(immutable); // String → StringBuilder

        mutable.append(" World!"); // Можем изменять
        System.out.println("Измененный StringBuilder: " + mutable);

        String newImmutable = mutable.toString(); // StringBuilder → String
        System.out.println("Обратно в String: " + newImmutable);

        System.out.println("\n7. Практический пример с цепочкой преобразований");

        // Цепочка преобразований
        String start = "Начало";

        // String → StringBuilder → изменение → String → StringBuffer
        StringBuilder tempBuilder = new StringBuilder(start);
        tempBuilder.insert(0, ">> ").append(" <<");

        String intermediate = tempBuilder.toString();
        StringBuffer finalBuffer = new StringBuffer(intermediate);
        finalBuffer.reverse();

        System.out.println("Исходная: " + start);
        System.out.println("После цепочки преобразований: " + finalBuffer);
    }
}