class Outer {
    private String privateField = "private поле";
    protected String protectedField = "protected поле";
    String defaultField = "default поле";
    public String publicField = "public поле";

    private void privateMethod() {
        System.out.println("private метод внешнего класса");
    }

    public void publicMethod() {
        System.out.println("public метод внешнего класса");
    }

    // Внутренний класс
    class Inner {
        void showAllAccess() {
            System.out.println("Inner class has access to:");

            // Доступ ко всем полям внешнего класса
            System.out.println("1. " + privateField);      // private доступен
            System.out.println("2. " + protectedField);    // protected доступен
            System.out.println("3. " + defaultField);      // default доступен
            System.out.println("4. " + publicField);       // public доступен

            // Вызов всех методов внешнего класса
            privateMethod();  // private метод доступен
            publicMethod();   // public метод доступен
        }
    }
}

class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.showAllAccess();
    }
}

//Внутренний класс (нестатический) имеет полный доступ
//ко ВСЕМ полям и методам внешнего класса, независимо от их спецификаторов доступа.