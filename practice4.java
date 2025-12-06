// AutoCloseableExample.java
class MyResource implements AutoCloseable {
    private String name;

    public MyResource(String name) {
        this.name = name;
        System.out.println("Ресурс " + name + " создан");
    }

    public void use() {
        System.out.println("Используем ресурс " + name);
    }

    @Override
    public void close() {
        System.out.println("Ресурс " + name + " закрыт");
    }
}

class AutoCloseableExample {
    public static void main(String[] args) {
        // try-with-resources автоматически закрывает ресурсы
        try (MyResource res1 = new MyResource("Файл");
             MyResource res2 = new MyResource("Соединение")) {

            res1.use();
            res2.use();

        } // Здесь автоматически вызываются close() для res1 и res2
    }
}