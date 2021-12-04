package lesson21.ex41_49.ex44;

public class Question44 {
    static int statA = 8;
    int nonStatB = 10;

    class innerClass{
        void test(){
            System.out.println(Question44.statA);
            System.out.println(Question44.this.nonStatB);
        }
    }
}

//44) How do you access hidden outer class variable in inner class?

//Уже был этот вопрос ранее, статику через Класс.переменная
//нон статика через Класс.this.переменная
