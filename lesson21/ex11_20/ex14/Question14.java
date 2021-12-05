package lesson21.ex11_20.ex14;

public class Question14 {
    int a = 10;
    static int x = 20;

    class Inner {
        void metod() {
            System.out.println(Question14.x);
            System.out.println(Question14.this.a);
        }
    }
}

//How do you access hidden outer class variable in inner class?

//к статическим переменным через Название класса.название переменной
//к не статическим переменным через Название класса.this.название переменной