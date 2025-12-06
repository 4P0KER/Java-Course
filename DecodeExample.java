class DecodeExample {
    public static void main(String[] args) {
        System.out.println("Примеры использования decode()");

        Integer num1 = Integer.decode("100");
        System.out.println("decode(\"100\") = " + num1);

        Integer num2 = Integer.decode("0100");
        System.out.println("decode(\"0100\") = " + num2);

        Integer num3 = Integer.decode("0x64");
        System.out.println("decode(\"0x64\") = " + num3);
        
        Integer num4 = Integer.decode("0XFF");
        System.out.println("decode(\"0XFF\") = " + num4);

        Integer num5 = Integer.decode("#A");
        System.out.println("decode(\"#A\") = " + num5);
        
        Integer num6 = Integer.decode("#1F");
        System.out.println("decode(\"#1F\") = " + num6);

        Integer num7 = Integer.decode("-100");
        System.out.println("decode(\"-100\") = " + num7);
        
        Integer num8 = Integer.decode("-0x10");
        System.out.println("decode(\"-0x10\") = " + num8);
    }
}