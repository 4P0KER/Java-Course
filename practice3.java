class NPEAutoboxingExample {
    public static void main(String[] args) {
        System.out.println("NullPointerException при автораспаковке\n");

        Boolean nullableBoolean = null;

        try {
            boolean primitive = nullableBoolean;  // ОШИБКА! null → boolean

        } catch (NullPointerException e) {
            System.out.println("ПОЙМАЛИ ИСКЛЮЧЕНИЕ: " + e);
            System.out.println("Причина: нельзя преобразовать null в boolean");
        }
    }
}