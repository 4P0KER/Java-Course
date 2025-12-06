// Два интерфейса с одинаковыми default методами
interface InterfaceA {
    default void show() {
        System.out.println("Метод из InterfaceA");
    }
}

interface InterfaceB {
    default void show() {
        System.out.println("Метод из InterfaceB");
    }
}

// Класс, реализующий оба интерфейса - ОШИБКА КОМПИЛЯЦИИ!
// class MyClass implements InterfaceA, InterfaceB {
//     // Ошибка: класс наследует несвязанные дефолты для show()
// }

// Правильное решение 1: Явное переопределение метода
class Solution1 implements InterfaceA, InterfaceB {
    @Override
    public void show() {
        System.out.println("Свой вариант из Solution1");
    }
}

// Правильное решение 2: Вызов конкретной реализации через super
class Solution2 implements InterfaceA, InterfaceB {
    @Override
    public void show() {
        // Вызываем конкретную реализацию из InterfaceA
        InterfaceA.super.show();
    }
}

// Правильное решение 3: Комбинированная реализация
class Solution3 implements InterfaceA, InterfaceB {
    @Override
    public void show() {
        System.out.println("Начало:");
        InterfaceA.super.show();  // Вызов из InterfaceA
        InterfaceB.super.show();  // Вызов из InterfaceB
        System.out.println("Конец.");
    }
}

class Main1 {
    public static void main(String[] args) {
        System.out.println("Решение 1: Своя реализация");
        Solution1 s1 = new Solution1();
        s1.show();

        System.out.println("\nРешение 2: Выбор одной реализации");
        Solution2 s2 = new Solution2();
        s2.show();

        System.out.println("\nРешение 3: Комбинирование");
        Solution3 s3 = new Solution3();
        s3.show();
    }
}