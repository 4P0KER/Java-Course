class Animal1 {
    public void makeSound() {
        System.out.println("Животное издает звук");
    }
}

class Dog extends Animal1 {

    // Хотим переопределить метод, но допустили опечатку
    //@Override  //  Аннотация @Override ПРЕДУПРЕДИТ об ошибке!
    //public void makeSount() {  // Опечатка: sound → sount

    @Override  // Компилятор проверит, что метод действительно переопределяется
    public void makeSound() {  // Правильное имя метода
        System.out.println("Собака лает: Гав-гав!");
    }
}

class Main2 {
    public static void main(String[] args) {
        Animal1 myDog = new Dog();
        myDog.makeSound();
    }
}