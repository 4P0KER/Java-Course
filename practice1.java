class Parent{
    public final void finalMethod(){
        System.out.println("Не переопределяемый метод");
    }
    public void noFinalMethod(){
        System.out.println("Переопределяемый метод");
    }
}

class Child extends Parent{
    // ОШИБКА КОМПИЛЯЦИИ - нельзя переопределить final метод
    // public void finalMethod() {
    //     System.out.println("Попытка переопределения");
    // }

    @Override
    public void noFinalMethod() {
        System.out.println("Переопределение метода");
    }
}

class Mian{
    public static void main(String[] args){
        Child obj = new Child();
        obj.finalMethod(); // вызов из родительского класса
        obj.noFinalMethod(); // вызов переопределенного метода
    }
}