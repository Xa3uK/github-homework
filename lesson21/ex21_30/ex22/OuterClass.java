package lesson21.ex21_30.ex22;

class OuterClass {
    static class InnerClass {
        int i;
    }
}

//22) How do you access the field ‘i’ of ‘InnerClass’ in the below example?
class Main {
    public static void main(String[] args) {
        int a = new OuterClass.InnerClass().i;
    }
}
