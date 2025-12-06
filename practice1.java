
/**
 * Демонстрация модификаторов доступа для внутренних классов
 */
class VisibilityExample {
    public static void main(String[] args) {
        // Создаем экземпляр внешнего класса
        Library library = new Library();

        // Доступ к общедоступному внутреннему классу
        Library.PublicCatalog publicCatalog = library.new PublicCatalog();
        publicCatalog.viewBooks();

        // В том же пакете доступны также защищенные и классы по умолчанию
        Library.ProtectedArchive protectedArchive = library.new ProtectedArchive();
        protectedArchive.browseArchives();

        Library.InternalStorage internalStorage = library.new InternalStorage();
        internalStorage.checkStorage();

        // Приватный класс недоступен напрямую
        // Library.SecretVault secretVault = library.new SecretVault(); // Ошибка!

        // Используем публичный метод библиотеки для доступа к приватному классу
        library.showSecretVault();
    }
}

/**
 * Класс библиотеки, содержащий разные типы внутренних классов
 */
class Library {
    // Поля с разной видимостью
    private String secretCollection = "Древние манускрипты";
    protected String rareBooks = "Редкие издания XIX века";
    String standardBooks = "Обычный книжный фонд";
    public String publicCatalog = "Открытый каталог";

    // 1. ОБЩЕДОСТУПНЫЙ внутренний класс
    public class PublicCatalog {
        public void viewBooks() {
            System.out.println("\nПубличный каталог:");
            System.out.println("Доступ открыт для всех посетителей");
            System.out.println("Содержимое: " + publicCatalog);
            // Имеет полный доступ ко всем полям Library
            System.out.println("Также видит (но не показывает): " + secretCollection);
        }
    }

    // 2. ЗАЩИЩЕННЫЙ внутренний класс
    protected class ProtectedArchive {
        public void browseArchives() {
            System.out.println("\nЗащищенный архив:");
            System.out.println("Только для сотрудников и партнеров библиотеки");
            System.out.println("Редкие книги: " + rareBooks);
            // Доступ к другим полям тоже есть
            System.out.println("Общий фонд: " + standardBooks);
        }
    }

    // 3. ВНУТРЕННИЙ КЛАСС по умолчанию (package-private)
    class InternalStorage {
        void checkStorage() {
            System.out.println("\nВнутреннее хранилище:");
            System.out.println("Для служебного использования в пределах пакета");
            System.out.println("Обычные книги: " + standardBooks);
            // Может обращаться к защищенным полям
            System.out.println("Редкий фонд: " + rareBooks);
        }
    }

    // 4. ПРИВАТНЫЙ внутренний класс
    private class SecretVault {
        private void openVault() {
            System.out.println("\nСекретный сейф:");
            System.out.println("Доступ только для директора библиотеки");
            System.out.println("Секретная коллекция: " + secretCollection);
            // Видит все, но никому не показывает
            System.out.println("Также содержит: " + rareBooks + " и " + standardBooks);
        }
    }

    // Публичный метод для работы с приватным классом
    public void showSecretVault() {
        SecretVault vault = new SecretVault();
        vault.openVault();
    }

    // Геттер для защищенного класса
    public ProtectedArchive getArchiveAccess() {
        return new ProtectedArchive();
    }
}

/**
 * Вспомогательный класс в том же пакете для демонстрации доступа
 */
class LibraryAssistant {
    public void performTasks() {
        Library mainLibrary = new Library();

        System.out.println("\nРабота ассистента в том же пакете");

        // Все, кроме private, доступно
        Library.PublicCatalog catalog = mainLibrary.new PublicCatalog();
        catalog.viewBooks();

        Library.ProtectedArchive archive = mainLibrary.new ProtectedArchive();
        archive.browseArchives();

        Library.InternalStorage storage = mainLibrary.new InternalStorage();
        storage.checkStorage();
    }
}

/**
 * Пример наследования для демонстрации доступа к protected
 */
class UniversityLibrary extends Library {
    public void universityAccess() {
        System.out.println("\nДоступ из университетской библиотеки-наследника");

        // Public и Protected доступны наследникам
        PublicCatalog catalog = new PublicCatalog();
        catalog.viewBooks();

        ProtectedArchive archive = new ProtectedArchive();
        archive.browseArchives();

        // InternalStorage тоже доступен, если в том же пакете
        InternalStorage storage = new InternalStorage();
        storage.checkStorage();
    }
}