class Animal {
    public void makeSound() {
        System.out.println("Животное издает звук");
    }
    public void move(){
        System.out.println("Животное передвигается");

    }
    public void move(String direction){
        System.out.println("Животное движется в направлении: " + direction);
    }
}

class Dog extends Animal {
    @Override  // Аннотация - указывает на переопределение
    public void makeSound() {
        System.out.println("Собака говорит: Гав-гав!");
    }
    @Override
    public void move() {
        System.out.println("Собака бегает на четырех лапах");
    }
    @Override
    public void move(String direction) {
        System.out.println("Собака бежит в направлении " + direction + ", виляя хвостом");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Кот говорит: Мяу!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myRat = new Animal();
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myRat.makeSound();
        myDog.makeSound();  // "Собака говорит: Гав-гав!"
        myCat.makeSound();  // "Кот говорит: Мяу!"

        myRat.move();
        myRat.move("влево");
        myCat.move();
        myDog.move("прямо");
    }
}