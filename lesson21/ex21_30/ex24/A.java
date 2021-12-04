package lesson21.ex21_30.ex24;


class A {
    class B {
        //        сначала я сделал просто вот так, но при проверке оказалось что надо по другому
        class C extends B {

        }
    }
}

class C extends A.B {
    public C() {
        new A().super();
    }

}
//24) Write a Class C which should extend Class B in the below example?
