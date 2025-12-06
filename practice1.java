// Интерфейс с неабстрактным (default) и статическим методами
interface Greeting {

    // Статический метод интерфейса
    static void sayHelloStatic() {
        System.out.println("Привет из статического метода интерфейса!");
    }

    // Неабстрактный (default) метод интерфейса
    default void sayHelloDefault() {
        System.out.println("Привет из default метода интерфейса!");
    }

    // Абстрактный метод (необязательно в этом примере)
    void sayHello();
}

// Класс, реализующий интерфейс
class Person implements Greeting {

    // Обязательно реализуем абстрактный метод
    @Override
    public void sayHello() {
        System.out.println("Привет от Person!");
    }

    // Можем переопределить default метод (но не обязаны)
    @Override
    public void sayHelloDefault() {
        System.out.println("Переопределенный default метод в Person");
    }
}

// Главный класс для демонстрации
class Main {
    public static void main(String[] args) {

        System.out.println("1. Создаем объект Person");
        Person person = new Person();

        System.out.println("\n2. Вызов методов");

        // Способ 1: Вызов абстрактного метода (реализованного в классе)
        person.sayHello();  // Вызываем метод, реализованный в Person

        // Способ 2: Вызов default метода (из интерфейса или переопределенного)
        person.sayHelloDefault();  // Вызываем переопределенную версию

        // Способ 3: Вызов статического метода интерфейса
        Greeting.sayHelloStatic();  // Только через имя интерфейса!
        // Person.sayHelloStatic();  // ОШИБКА! Нельзя вызвать через класс

        System.out.println("\n3. Использование через ссылку на интерфейс");
        Greeting greeting = person;  // Неявное приведение типа

        // Вызываем те же методы через интерфейсную ссылку
        greeting.sayHello();        // Вызовет реализацию из Person
        greeting.sayHelloDefault(); // Вызовет переопределенный метод

        // greeting.sayHelloStatic(); // ОШИБКА! Нельзя вызвать статический метод через объект
    }
}