// Базовый класс
class Transport {
    public void move() {
        System.out.println("Транспорт двигается");
    }
}

// Легковой автомобиль
class Car extends Transport {
    @Override
    public void move() {
        System.out.println("Машина едет по дороге");
    }
}

// Самолет
class Airplane extends Transport {
    @Override
    public void move() {
        System.out.println("Самолет летит в небе");
    }
}

// Корабль
class Ship extends Transport {
    @Override
    public void move() {
        System.out.println("Корабль плывет по воде");
    }
}

// Использование
class TransportTest {
    public static void useTransport(Transport transport) {
        transport.move();  // Работает с любым транспортом
    }

    static void main(String[] args) {
        Transport car = new Car();
        Transport airplane = new Airplane();
        Transport ship = new Ship();

        useTransport(car);      // Вывод: "Машина едет по дороге"
        useTransport(airplane); // Вывод: "Самолет летит в небе"
        useTransport(ship);     // Вывод: "Корабль плывет по воде"
    }
}