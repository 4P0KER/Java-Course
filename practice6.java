class Narrowing{
    static void main(String[] args){


        // double -> float
        double d1 = 5.343242423;
        float f1 = (float) d1;
        System.out.println("double:" + d1 + " | float:" + f1);

        // float -> int
        float f2 = 87.32314f;
        int i1 = (int) f2;
        System.out.println("float:" + f2 + " | int:" + i1);

        // int -> byte
        int i2 = 64;
        byte b1 = (byte) i2;
        System.out.println("int:" + i2 + " | byte:" + b1);

        // double -> short
        double d2 = 94.32;
        short s1 = (short) d2;
        System.out.println("double:" + d2 + " | short:" + s1);

    }
}