// Файл: AccessExample.java

// 1. Основной класс
class Product {
    // private - только внутри класса
    private String secretCode;

    // default - только в том же пакете  
    int internalId;

    // protected - в пакете и наследникам
    protected double discount;

    // public - всем
    public String name;
    public double price;

    // Конструктор
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.secretCode = generateCode();
        this.internalId = 1;
        this.discount = 0.0;
    }

    // private метод
    private String generateCode() {
        return "PRD-" + System.currentTimeMillis();
    }

    // default метод
    void setInternalId(int id) {
        this.internalId = id;
    }

    // protected метод  
    protected void applyDiscount(double percent) {
        discount = percent;
        price = price * (1 - percent/100);
    }

    // public метод
    public void display() {
        System.out.println(name + ": $" + price +
                " (скидка " + discount + "%)");
    }
}

// 2. Наследник в том же файле (тот же пакет)
class DiscountedProduct extends Product {
    public DiscountedProduct(String name, double price) {
        super(name, price);
        // protected доступ - разрешен
        this.discount = 10.0;
        applyDiscount(10.0);

        // default доступ - разрешен (тот же пакет)
        this.internalId = 100;
        setInternalId(101);

        // private доступ - ЗАПРЕЩЕН
        // this.secretCode = "new"; // Ошибка!
    }
}

// 3. Главный класс
public class AccessExample {
    public static void main(String[] args) {
        Product product = new Product("Ноутбук", 1000);

        // public - доступно
        product.name = "Ноутбук Dell";
        product.display();

        // default - доступно (тот же пакет)
        product.internalId = 5;
        product.setInternalId(6);

        // protected - доступно (тот же пакет)
        product.discount = 5.0;
        product.applyDiscount(5.0);
        product.display();

        // private - НЕ доступно
        // product.secretCode = "123"; // Ошибка!
        // product.generateCode(); // Ошибка!

        // Проверяем наследника
        DiscountedProduct discountProd = new DiscountedProduct("Телефон", 500);
        discountProd.display();

        System.out.println("\nИтог:");
        System.out.println("private - только внутри класса");
        System.out.println("default - только в пакете");
        System.out.println("protected - в пакете + наследникам");
        System.out.println("public - всем");
    }
}