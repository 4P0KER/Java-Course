class A {
    public final int a;

    // Конструктор по умолчанию
    public A(){
        a = 0;
    };

    // Параметризованный конструктор
    public A(int value){
        a = value;
    }
}

class B{
    public final int b;
    // Блок инициализации
    {
        b = 0;
    }
}