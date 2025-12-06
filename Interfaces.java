// ПРАКТИКА #1: default/package-private интерфейс
// Доступен только внутри пакета 'mypackage'
interface PackagePrivateInterface {
    void show();
}

// ПРАКТИКА #2: public интерфейс  
// Доступен везде (из любого пакета)
public interface Interfaces {
    void display();
}

// ЗАПРЕЩЕНО! Интерфейс не может быть protected
// protected interface ProtectedInterface {  // ОШИБКА КОМПИЛЯЦИИ!
//     void method();
// }

// ЗАПРЕЩЕНО! Интерфейс не может быть private
// private interface PrivateInterface {  // ОШИБКА КОМПИЛЯЦИИ!
//     void method();
// }


// Главный класс для демонстрации
class InterfaceVisibility {
    public static void main(String[] args) {
        System.out.println("Практика #1: default интерфейс");
        System.out.println("Доступен только в пакете 'mypackage'");

        // Реализация package-private интерфейса
        class LocalImpl1 implements PackagePrivateInterface {
            public void show() {
                System.out.println("PackagePrivateInterface реализован");
            }
        }
        new LocalImpl1().show();

        System.out.println("\nПрактика #2: public интерфейс");
        System.out.println("Доступен из любого пакета");

        // Реализация public интерфейса
        class LocalImpl2 implements Interfaces {
            public void display() {
                System.out.println("PublicInterface реализован");
            }
        }
        new LocalImpl2().display();

        System.out.println("\nПрактика #3 и #4");
        System.out.println("protected и private интерфейсы НЕВОЗМОЖНЫ в Java!");
        System.out.println("Будут ошибки компиляции.");
    }
}

// Еще один класс в том же пакете - имеет доступ к обоим интерфейсам
class AnotherClassInSamePackage implements PackagePrivateInterface, Interfaces {
    public void show() {
        System.out.println("Доступ к PackagePrivateInterface из того же пакета");
    }

    public void display() {
        System.out.println("Доступ к PublicInterface из того же пакета");
    }
}