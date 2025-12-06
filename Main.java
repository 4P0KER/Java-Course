// Интерфейс с вложенным классом
interface Vehicle {
    void drive();

    // Вложенный класс (автоматически public static)
    class Info {
        void show() {
            System.out.println("Информация о транспорте");
        }
    }
}

// Главный класс
class SimpleExample {
    public static void main(String[] args) {
        // Создаем объект вложенного класса
        Vehicle.Info info = new Vehicle.Info();

        // Вызываем метод вложенного класса
        info.show();
    }
}