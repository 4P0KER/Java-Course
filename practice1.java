class BasicDataTypes{
    public static void main(String[] args){

        byte valueByte = -4; // [-128;127]
        byte zeroByte = 0;
        short valueShort = 28674; // [-32768;32767]
        short zeroShort = 0;
        int valueInt = 233332324; //[-2^31;2^31 - 1]
        int zeroInt = 0;
        long valueLong = 9023372036854775807L; // [-2^64;2^64 - 1]
        long zeroLong = 0;
        float valueFloat = 67.16f; // 32 бита
        float zeroFloat = 0.0f;
        double valueDouble = 2500.7543242; // 64 бита
        double zeroDouble = 0.0;
        char valueChar = 'C';
        char zeroChar = '\u0000';
        boolean valueBoolean = true;
        boolean zeroBoolean = false;

        System.out.println("Типы переменных и их знаяения:");
        System.out.println("byte: " + valueByte + " | DefualtByte: " + zeroByte);
        System.out.println("short: " + valueShort + " | DefualtShort: " + zeroShort);
        System.out.println("int: " + valueInt + " | DefualtInt: " + zeroInt);
        System.out.println("long: " + valueLong + " | DefualtLong: " + zeroLong);
        System.out.println("float: " + valueFloat + " | DefualtFloat: " + zeroFloat);
        System.out.println("double: " + valueDouble + " | DefualtDouble: " + zeroDouble);
        System.out.println("char: " + valueChar + " | DefualtChar: " + zeroChar);
        System.out.println("boolean: " + valueBoolean + " | DefualtBoolean: " + zeroBoolean);


    }
}