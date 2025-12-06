public class A {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }

    public void main(String[] args){

        printVars(); //прямой вызов

        A a = new A(); // через объект
        a.printVars();

        A.printVars(); //Через имя класса
    }
}
