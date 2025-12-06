class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void makeSound() {
        System.out.println(name + " издает звук");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    void bark() {
        System.out.println(name + " лает: Гав-гав!");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    void meow() {
        System.out.println(name + " мяукает: Мяу!");
    }
}

class SimpleInstanceofExample {
    public static void main(String[] args) {
        System.out.println("Пример instanceof");

        // Создаем животных
        Animal animal1 = new Dog("Бобик");
        Animal animal2 = new Cat("Мурка");
        Animal animal3 = null;  // null объект

        // 1. Проверка типа объектов
        System.out.println("\nПроверка типов:");
        System.out.println("animal1 это Dog? " + (animal1 instanceof Dog));      // true
        System.out.println("animal1 это Cat? " + (animal1 instanceof Cat));      // false
        System.out.println("animal1 это Animal? " + (animal1 instanceof Animal)); // true

        System.out.println("\nanimal2 это Dog? " + (animal2 instanceof Dog));      // false
        System.out.println("animal2 это Cat? " + (animal2 instanceof Cat));      // true
        System.out.println("animal2 это Animal? " + (animal2 instanceof Animal)); // true

        // 2. Проверка null объекта
        System.out.println("\nПроверка null объекта:");
        System.out.println("animal3 это Dog? " + (animal3 instanceof Dog));      // false
        System.out.println("animal3 это Animal? " + (animal3 instanceof Animal)); // false
        System.out.println("animal3 == null? " + (animal3 == null));             // true
    }
}