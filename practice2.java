class A {
    int a1 = 1; // по умолчанию
    public int a2 = 2; // public
    protected int a3 = 3; // protected
    private int a4 = 4; // private

    void method1() {
        System.out.println("A1");
    }

    public void method2() {
        System.out.println("A2");
    }

    protected void method3() {
        System.out.println("A3");
    }

    private void method4() {
        System.out.println("A4");
    }

}

class B extends A {
  public void mainB(){
      System.out.println("Класс B");
      System.out.println("a1 = " + a1); // доступно (в одном пакете)
      System.out.println("a2 = " + a2); // доступно (public)
      System.out.println("a3 = " + a3); // доступно (наследник)
      //System.out.println("a4 = " + a4); // недоступно (private)
      method1(); // доступно (в одном пакете)
      method2(); // доступно (public)
      method3(); // доступно (наследник)
      // method4(); // недоступно (private)
  }

}

class C extends B {
    public void mainC(){
        System.out.println("Класс C");
        System.out.println("a1 = " + a1); // доступно (в одном пакете)
        System.out.println("a2 = " + a2); // доступно (public)
        System.out.println("a3 = " + a3); // доступно (наследник A через B)
        //System.out.println("a4 = " + a4); // недоступно (private)
        method1(); // доступно (в одном пакете)
        method2(); // доступно (public)
        method3(); // доступно (наследник)
        // method4(); // недоступно (private)
    }
}

class Main1{
    public void main(String[] args){
        B b1 = new B();
        C c1 = new C();
        b1.mainB();
        c1.mainC();
    }
}