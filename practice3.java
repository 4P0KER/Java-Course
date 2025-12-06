/**
 * Пример, демонстрирующий доступ внешнего класса к внутреннему
 */
class Main1 {
    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        outer.testAccessToInner();
    }
}

class Outer1 {
    // Внешний класс создает экземпляр внутреннего класса
    public void testAccessToInner() {
        System.out.println("Доступ из внешнего класса Outer");

        // 1. Создание экземпляров внутренних классов
        PublicInner publicInner = new PublicInner();
        ProtectedInner protectedInner = new ProtectedInner();
        DefaultInner defaultInner = new DefaultInner();
        PrivateInner privateInner = new PrivateInner();

        System.out.println("\n1. Доступ к public полю/методу:");
        System.out.println("   Поле: " + publicInner.publicField);  //ДОСТУПЕН
        publicInner.publicMethod();  //ДОСТУПЕН

        System.out.println("\n2. Доступ к protected полю/методу:");
        System.out.println("   Поле: " + protectedInner.protectedField);  //ДОСТУПЕН
        protectedInner.protectedMethod();  //ДОСТУПЕН

        System.out.println("\n3. Доступ к default полю/методу:");
        System.out.println("   Поле: " + defaultInner.defaultField);  //ДОСТУПЕН
        defaultInner.defaultMethod();  //ДОСТУПЕН

        System.out.println("\n4. Доступ к private полю/методу:");
        // System.out.println(privateInner.privateField);  //НЕДОСТУПЕН - private!
        // privateInner.privateMethod();  //НЕДОСТУПЕН - private!
        System.out.println("   Private поле/метод недоступны даже внешнему классу!");

        // Но можно использовать публичные методы для доступа к private данным
        System.out.println("   Через публичный метод: " + privateInner.getPrivateField());
    }

    // ВОПРОС: Имеет ли внешний класс доступ к полям и методам внутреннего класса?
    // ОТВЕТ: Да, но только к тем, которые доступны по спецификаторам доступа.
    // Внешний класс работает с внутренним как с обычным классом.

    // ВОПРОС: Как возможность доступа зависит от спецификаторов доступа?
    // ОТВЕТ: Полностью зависит! Те же правила, что и для обычных классов:
    // - public: доступен везде
    // - protected: доступен в пакете и наследникам
    // - default: доступен только в пакете
    // - private: недоступен даже внешнему классу

    // ======================= ВНУТРЕННИЕ КЛАССЫ =======================

    // 1. PUBLIC внутренний класс
    public class PublicInner {
        public String publicField = "public поле Inner";
        protected String protectedField = "protected поле Inner";
        String defaultField = "default поле Inner";
        private String privateField = "private поле Inner";

        public void publicMethod() {
            System.out.println("   public метод Inner");
        }

        protected void protectedMethod() {
            System.out.println("   protected метод Inner");
        }

        void defaultMethod() {
            System.out.println("   default метод Inner");
        }

        private void privateMethod() {
            System.out.println("   private метод Inner");
        }

        // Публичный геттер для private поля
        public String getPrivateField() {
            return privateField;
        }
    }

    // 2. PROTECTED внутренний класс
    protected class ProtectedInner {
        public String publicField = "public поле ProtectedInner";
        protected String protectedField = "protected поле ProtectedInner";

        public void publicMethod() {
            System.out.println("   public метод ProtectedInner");
        }

        protected void protectedMethod() {
            System.out.println("   protected метод ProtectedInner");
        }
    }

    // 3. DEFAULT (package-private) внутренний класс
    class DefaultInner {
        public String publicField = "public поле DefaultInner";
        String defaultField = "default поле DefaultInner";

        public void publicMethod() {
            System.out.println("   public метод DefaultInner");
        }

        void defaultMethod() {
            System.out.println("   default метод DefaultInner");
        }
    }

    // 4. PRIVATE внутренний класс
    private class PrivateInner {
        public String publicField = "public поле PrivateInner";
        private String privateField = "private поле PrivateInner";

        public void publicMethod() {
            System.out.println("   public метод PrivateInner");
        }

        private void privateMethod() {
            System.out.println("   private метод PrivateInner");
        }

        // Публичный геттер
        public String getPrivateField() {
            return privateField;
        }
    }

}