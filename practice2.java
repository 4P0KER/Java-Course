//Если тип возвращаемого значения не совпадает, то программа выдаст ошибку компиляции
//Переопределенный метод должен возвращать тот же тип, что и основной метод

class Animal {
    void say() {
        System.out.println("Животное издает звук");
    }
}

class Cat extends Animal {
    @Override
    void say() {
        System.out.println("Кошка говорит: Мяу!");
    }
}

class Main1 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal cat = new Cat(); // Можно хранить Cat в переменной Animal

        animal.say();
        cat.say();
    }
}

