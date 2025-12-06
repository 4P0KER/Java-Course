class OperatorsExamples {
    public static void main(String[] args) {

        System.out.println("\nОператоры присваивания:");

        int a = 10, b = 5;

        a += 5;
        System.out.println("+= : a += 5 → " + a);
        a -= 3;
        System.out.println("-= : a -= 3 → " + a);
        a *= 2;
        System.out.println("*= : a *= 2 → " + a);
        a /= 4;
        System.out.println("/= : a /= 4 → " + a);
        a %= 4;
        System.out.println("%= : a %= 4 → " + a);

        System.out.println("\nТернарный оператор ? :");

        int age = 20;
        String status = (age >= 18) ? "Взрослый" : "Ребёнок";
        System.out.println("age = " + age + ", status = " + status);

        int score = 75;
        String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : (score >= 70) ? "C" : "D";
        System.out.println("score = " + score + ", grade = " + grade);

        System.out.println("\nЛогические операторы:");

        boolean x = true;
        boolean y = false;
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x || y = " + (x || y));
        System.out.println("x && y = " + (x && y));
        System.out.println("x | y = " + (x | y));
        System.out.println("x & y = " + (x & y));
        System.out.println("x ^ y = " + (x ^ y));
        System.out.println("!x = " + (!x));

        System.out.println("\nОператоры сравнения:");
        int num1 = 10, num2 = 20;
        System.out.println("num1 = " + num1 + ", num2 = " + num2);
        System.out.println("num1 == num2 : " + (num1 == num2));
        System.out.println("num1 != num2 : " + (num1 != num2));
        System.out.println("num1 > num2 : " + (num1 > num2));
        System.out.println("num1 < num2 : " + (num1 < num2));
        System.out.println("num1 >= 10 : " + (num1 >= 10));
        System.out.println("num2 <= 20 : " + (num2 <= 20));


        System.out.println("\nПобитовые операторы:");

        int bit1 = 5;   // 0101
        int bit2 = 3;   // 0011
        System.out.println("bit1 = 5 (0101), bit2 = 3 (0011)");
        System.out.println("bit1 & bit2 = " + (bit1 & bit2) + " (0001)");   // 1
        System.out.println("bit1 | bit2 = " + (bit1 | bit2) + " (0111)");   // 7
        System.out.println("bit1 ^ bit2 = " + (bit1 ^ bit2) + " (0110)");   // 6

        System.out.println("\nПобитовые сдвиги:");
        int shift = 8;  // 00001000
        System.out.println("shift = " + shift + " (00001000)");
        System.out.println("shift << 1 = " + (shift << 1) + " (00010000)");  // 16
        System.out.println("shift >> 1 = " + (shift >> 1) + " (00000100)");  // 4
        System.out.println("-8 >> 1 = " + (-8 >> 1));    // -4
        System.out.println("-8 >>> 1 = " + (-8 >>> 1));  // 2147483644

        System.out.println("\nАрифметические операторы:");

        int m = 15, n = 4;
        System.out.println("m = " + m + ", n = " + n);
        System.out.println("m + n = " + (m + n));
        System.out.println("m - n = " + (m - n));
        System.out.println("m * n = " + (m * n));
        System.out.println("m / n = " + (m / n));
        System.out.println("m % n = " + (m % n));

        int post = 5;
        System.out.println("Постфиксный инкремент:" + post++);

        int pre = 5;
        System.out.println("\nПрефиксный инкремент:" + ++pre);

        int counter = 10;
        System.out.println("Префиксный декремент = " + --counter);
        System.out.println("Постфиксный декремент = " + counter--);

        System.out.println("\nУнарные операторы:");
        int val = 7;
        System.out.println("val = " + val);
        System.out.println("~val = " + (~val));

        boolean flag = false;
        System.out.println("flag = " + flag);
        System.out.println("!flag = " + (!flag));


        System.out.println("\nОператоры для String: ");
        String str1 = "Hello";
        String str2 = "World";

        // Конкатенация
        String concat = str1 + " " + str2;
        System.out.println("+ для String: " + concat);

        // += для String
        str1 += " Java";
        System.out.println("+= для String: " + str1);

        // Сравнение строк
        System.out.println("== для String: " + (str1 == str1));
        System.out.println("!= для String: " + (str1 != str2));

        // Классы-оболочки
        System.out.println("\nКлассы-оболочки: ");
        Integer intObj1 = 10;
        Integer intObj2 = 20;
        System.out.println("== для Integer: " + (intObj1 == intObj2));
        System.out.println("+ для Integer: " + (intObj1 + intObj2));

        // Скобки для изменения приоритета
        System.out.println("\nПриоритет операторов: ");
        int withBrackets = (a + b) * 2;
        int withoutBrackets = a + b * 2;
        System.out.println("(a + b) * 2 = " + withBrackets);
        System.out.println("a + b * 2 = " + withoutBrackets);

    }
}