/**
 * Примеры использования основных аннотаций Java
 */

// 1. @Override - Указывает, что метод переопределяет метод суперкласса
class Parent {
    void display() {
        System.out.println("Родительский метод");
    }
}

class Child extends Parent {
    @Override  // ← Помогает избежать ошибок при переопределении
    void display() {
        System.out.println("Дочерний метод (переопределен)");
    }

    // Без @Override легко допустить опечатку:
    // void displaay() { ... }  // Ошибка не обнаружится без @Override
}

// 2. @Deprecated - Помечает устаревший код (не рекомендуется к использованию)
class OldCalculator {
    /**
     * Старый метод сложения
     * @deprecated используйте новый метод {@link #add(int, int)}
     */
    @Deprecated(since = "1.5", forRemoval = false)
    public int sum(int a, int b) {
        return a + b;
    }

    // Новый метод
    public int add(int a, int b) {
        return a + b;
    }
}

// 3. @SuppressWarnings - Отключает предупреждения компилятора
class AnnotationExamples {

    @SuppressWarnings("deprecation")
    public static void useDeprecatedMethod() {
        OldCalculator calc = new OldCalculator();
        int result = calc.sum(5, 3);  // Без @SuppressWarnings будет предупреждение
        System.out.println("Результат: " + result);
    }

    @SuppressWarnings("unchecked")
    public static void useRawTypes() {
        // Пример с сырыми типами (без дженериков)
        java.util.List list = new java.util.ArrayList();  // Предупреждение без аннотации
        list.add("строка");
        System.out.println("Список: " + list);
    }

    @SuppressWarnings({"rawtypes", "unused"})
    public static void multipleWarnings() {
        java.util.List list;  // Несколько подавленных предупреждений
        int x;  // Неиспользуемая переменная
    }

    public static void main(String[] args) {
        System.out.println("Пример @Override");
        Child child = new Child();
        child.display();

        System.out.println("\nПример @Deprecated");
        OldCalculator calc = new OldCalculator();
        // calc.sum(2, 3);  // В IDE будет зачеркнуто с предупреждением

        System.out.println("\nПример @SuppressWarnings");
        useDeprecatedMethod();
        useRawTypes();
    }
}
