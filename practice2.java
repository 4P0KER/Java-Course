import java.util.*;

//Конструкции <? extends T> и <? super T> отвечают за то, какие типы можно передавать в обобщенный метод
//<? extends T> позволяет читать из коллекции, но нельзя добавлять
//<? super T> позволяет добавлять в коллекцию, но нельзя читать

class SimpleWildcardDemo {

    // Метод читает элементы из списка Animal или его подклассов
    static void printAnimals(List<? extends Animal> list) {
        for (Animal animal : list) {
            System.out.println("Животное: " + animal.getName());
        }
    }

    // Метод добавляет Cat в список Cat или его суперклассов
    static void addCat(List<? super Cat> list) {
        list.add(new Cat("Мурзик"));
        System.out.println("Добавлен кот Мурзик");
    }

    public static void main(String[] args) {
        // Создаем списки разных типов
        List<Cat> cats = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        // Заполняем списки
        cats.add(new Cat("Барсик"));
        dogs.add(new Dog("Шарик"));
        animals.add(new Animal("Неизвестное"));

        System.out.println("Пример <? extends Animal>");
        printAnimals(cats);    // Cat — потомок Animal
        printAnimals(dogs);    // Dog — потомок Animal
        printAnimals(animals); // Animal — тот же тип

        System.out.println("\nПример <? super Cat>");
        addCat(cats);      // Cat — тот же тип
        addCat(animals);   // Animal — супертип Cat
        addCat(objects);   // Object — супертип Cat

    }
}


class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}