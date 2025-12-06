class BooleanCreation {
    public static void main(String[] args) {
        Boolean b1 = Boolean.valueOf(true);         // через valueOf(boolean)
        Boolean b2 = Boolean.valueOf("true");       // через valueOf(String)
        Boolean b3 = true;                             // Autoboxing
        Boolean b4 = Boolean.parseBoolean("true");  // через parseBoolean
        Boolean b5 = Boolean.FALSE;                    //статистическая константа

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
    }
}