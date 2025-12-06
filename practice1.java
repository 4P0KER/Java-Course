class AllMethodsWithVarargs {

    // Сумма целых чисел
    public int sum(int... numbers) {
        System.out.print("Сумма int: ");
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) System.out.print(" + ");
        }
        System.out.println(" = " + total);
        return total;
    }

    // Сумма вещественных чисел
    public double sum(double... numbers) {
        System.out.print("Сумма double: ");
        double total = 0.0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) System.out.print(" + ");
        }
        System.out.println(" = " + total);
        return total;
    }

    // МЕТОД 3: Объединение строк
    public String sum(String... strings) {
        System.out.print("Объединение строк: ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            result.append(strings[i]);
            System.out.print("\"" + strings[i] + "\"");
            if (i < strings.length - 1) System.out.print(" + ");
        }
        System.out.println(" = \"" + result + "\"");
        return result.toString();
    }

    public static void main(String[] args) {
        AllMethodsWithVarargs calculator = new AllMethodsWithVarargs();

        // Вызов метода 1 с разным количеством int
        calculator.sum(1, 2, 3);
        calculator.sum(10, 20);

        System.out.println();

        // Вызов метода 2 с разным количеством double
        calculator.sum(1.5, 2.5, 3.5);
        calculator.sum(10.1, 20.2);
        calculator.sum(3, 3.14);

        System.out.println();

        // Вызов метода 3 с разным количеством строк
        calculator.sum("Hello", " ", "World");
        calculator.sum("Java", " ", "is", " ", "cool");
        calculator.sum("Один");
    }
}