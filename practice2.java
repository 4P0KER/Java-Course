
// Final класс - нельзя наследовать
final class FinalClass {
    public void doSomething() {
        System.out.println("Действие");
    }
}

// ОШИБКА КОМПИЛЯЦИИ - нельзя наследовать от final класса
// class NewClass extends FinalClass {
//     }
// }

// Обычный класс - можно наследовать
class NormalClass {
    public void display() {
        System.out.println("Это обычный класс");
    }
}

// OK - наследование от обычного класса
class NewClass extends NormalClass {
    @Override
    public void display() {
        System.out.println("Метод переопределен в подклассе");
    }
}

class FinalClassExample {
    public static void main(String[] args) {
        FinalClass finalObj = new FinalClass();
        finalObj.doSomething();

        NewClass subObj = new NewClass();
        subObj.display();
    }
}