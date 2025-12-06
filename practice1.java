// 1. Наш generic класс
class Wrapper<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

// 2. Главный класс
class SimpleInstanceofExample {
    public static void main(String[] args) {
        // Создаем объекты
        Wrapper<String> stringWrapper = new Wrapper<>();
        stringWrapper.setItem("Hello");

        Wrapper<Integer> intWrapper = new Wrapper<>();
        intWrapper.setItem(100);

        // 1. Проверить, что это Wrapper (любого типа)
        System.out.println("1. Это Wrapper?");
        System.out.println("stringWrapper instanceof Wrapper: " +
                (stringWrapper instanceof Wrapper));  // true
        System.out.println("intWrapper instanceof Wrapper: " +
                (intWrapper instanceof Wrapper));      // true

        // 2. Проверить с wildcard (<?>)
        System.out.println("\n2. Это Wrapper<?>?");
        System.out.println("stringWrapper instanceof Wrapper<?>: " +
                (stringWrapper instanceof Wrapper<?>));  // true

        // 3. Проверить, что это Object (всегда true)
        System.out.println("\n3. Это Object?");
        System.out.println("stringWrapper instanceof Object: " +
                (stringWrapper instanceof Object));  // true

        // 4. Проверить, что это Wrapper<String>
        System.out.println("\n4. Это Wrapper<String>?");
        System.out.println("stringWrapper instanceof Wrapper<String>: " +
                (stringWrapper instanceof Wrapper<String>));  // true


    }
}