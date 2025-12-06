class Printer {

    // Печать строки
    public void print(String text) {
        System.out.println("Текст: " + text);
    }

    // Печать числа
    public void print(int number) {
        System.out.println("Число: " + number);
    }

    // Печать числа с пояснением
    public void print(String label, int number) {
        System.out.println(label + ": " + number);
    }
}

class Main{
    public void main(String[] args){
        Printer printer = new Printer();
        printer.print("Привет");        // Вызов print(String)
        printer.print(42);              // Вызов print(int)
        printer.print("Возраст", 25);   // Вызов print(String, int)
    }
}
