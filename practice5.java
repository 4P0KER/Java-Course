class Сonversion{
    static void main(String[] args){
        byte num1 = 78;
        int num2 = 5000;
        long num3 = 789454;
        float num4 = 34.5f;
        double num5 = 4.424;

        //Объяснение: в арифмитических выражениях выполняется расширяющее преобразование типов

        // byte + int -> int (int больше byte)
        var res1 = num1 + num2;
        System.out.println("byte + int = " + res1);
        System.out.println("Type:" + ((Object)res1).getClass().getSimpleName() + "\n");

        // int + long -> long (long больше int)
        var res2 = num2 + num3;
        System.out.println("int + long = " + res2);
        System.out.println("Type:" + ((Object)res2).getClass().getSimpleName()+ "\n");

        // int + float -> float (float больше int. float хранит дробные числа)
        var res3 = num2 + num4;
        System.out.println("int + float = " + res3);
        System.out.println("Type:" + ((Object)res3).getClass().getSimpleName()+ "\n");

        // float + double -> double (double больше float)
        var res4 = num4 + num5;
        System.out.println("float + double = " + res4);
        System.out.println("Type:" + ((Object)res4).getClass().getSimpleName()+ "\n");


    }
}