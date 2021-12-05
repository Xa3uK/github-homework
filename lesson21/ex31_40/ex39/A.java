package lesson21.ex31_40.ex39;

class A {
    class B {
        static final int i = 111;
    }
}
//39) You know that member inner classes can’t have static members in them.
// If it is true then why the below code doesn’t show any errors even though class B has a static field?

//статические и ФИНАЛЬНЫЕ переменные допускаются. Но только не методы