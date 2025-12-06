// Суперкласс (родительский класс)
class Animal {
    // Поле суперкласса
    protected String type = "Животное";

    // Конструктор суперкласса
    public Animal(String name) {
        System.out.println("Конструктор Animal: " + name);
    }

    // Метод суперкласса
    public void makeSound() {
        System.out.println("Животное издает звук");
    }
}

// Подкласс (дочерний класс)
class Dog extends Animal {
    // Поле подкласса с таким же именем, как в суперклассе
    private String type = "Собака";

    // Конструктор подкласса
    public Dog(String name) {
        // 1. Вызов конструктора суперкласса (должен быть первой строкой)
        super(name);
        System.out.println("Конструктор Dog");
    }

    public void displayInfo() {
        // 2. Доступ к полю суперкласса (через super)
        System.out.println("Тип из суперкласса: " + super.type);

    }

    @Override
    public void makeSound() {
        // 3. Вызов метода суперкласса
        super.makeSound();
        System.out.println("Собака лает: Гав-гав!");
    }
}


class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Барсик");
        System.out.println("\nВызов displayInfo()");
        dog.displayInfo();

        System.out.println("\nВызов makeSound()");
        dog.makeSound();


    }
}