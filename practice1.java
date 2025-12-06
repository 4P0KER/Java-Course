// this используется когда:
// 1) Обращение к полям и методам текущего класса
// 2) Вызов конструктора текущего класса
// super используется когда:
// 1) Для доступа к полям и методам родительского класса
// 2) Для вызова конструктора родительского класса


class Parent {
    protected int value = 10;

    public void show() {
        System.out.println("Родительский метод: " + value);
    }
}

class Child extends Parent {
    private int value = 20;  // скрывает поле value родителя

    public void printValues() {
        System.out.println("Локальное value: " + value);         // 20
        System.out.println("this.value: " + this.value);         // 20
        System.out.println("super.value: " + super.value);       // 10

        show();                 // вызовет Child.show() если он переопределен
        super.show();           // всегда вызовет Parent.show()
    }

    @Override
    public void show() {
        System.out.println("Дочерний метод: " + value);      // 20
        System.out.println("Родительское поле: " + super.value); // 10
    }
}

class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.printValues();
    }
}