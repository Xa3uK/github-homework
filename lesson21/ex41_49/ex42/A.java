package lesson21.ex41_49.ex42;

class A {
    int a;

    class B {
        int b;
    }

}

class C extends A {

}

//42) In the below code, Class C extends Class A which has Class B as a member inner class.
//        Then, can you tell whether the members of Class B are also inherited to Class C or not?

//Нет, в классе С доступны только переменные и методы класса А.
// Внутренние классы класса А нужно наследовать отдельно.