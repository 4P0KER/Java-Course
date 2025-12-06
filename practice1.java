class SwitchTypes {
    public static void main(String[] args) {

        // 1. byte / Byte
        byte byteValue = 2;
        switch(byteValue) {
            case 1: System.out.println("byte: 1"); break;
            case 2: System.out.println("byte: 2"); break;
            default: System.out.println("byte: other");
        }

        Byte byteObj = 2;
        switch(byteObj) {  // автоупаковка
            case 1: System.out.println("Byte: 1"); break;
            case 2: System.out.println("Byte: 2"); break;
        }

        // 2. short / Short
        short shortValue = 10;
        switch(shortValue) {
            case 10: System.out.println("short: 10"); break;
            case 20: System.out.println("short: 20"); break;
        }

        // 3. int / Integer
        int intValue = 100;
        switch(intValue) {
            case 100: System.out.println("int: 100"); break;
            case 200: System.out.println("int: 200"); break;
        }

        Integer intObj = 100;
        switch(intObj) {  // автоупаковка
            case 100: System.out.println("Integer: 100"); break;
        }

        // 4. char / Character
        char charValue = 'A';
        switch(charValue) {
            case 'A': System.out.println("char: A"); break;
            case 'B': System.out.println("char: B"); break;
        }

        Character charObj = 'A';
        switch(charObj) {
            case 'A': System.out.println("Character: A"); break;
        }

        // 5. enum (перечисления)
        Day today = Day.MONDAY;
        switch(today) {
            case MONDAY: System.out.println("Понедельник"); break;
            case TUESDAY: System.out.println("Вторник"); break;
            default: System.out.println("Другой день");
        }

        // 6. String
        String animal = "Dog";
        switch (animal){
            case "Cat": System.out.println("Кошка"); break;
            case "Dog": System.out.println("Собака"); break;
        }

    }

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}