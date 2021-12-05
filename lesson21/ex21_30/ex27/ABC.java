package lesson21.ex21_30.ex27;

class ABC {
    class XYZ {
        String s = "Inner - XYZ";
    }
}

class XYZ extends ABC {
    String s = "Outer - XYZ";

    class ABC extends XYZ {

    }
}

class MainClass {
    public static void main(String[] args) {
        System.out.println(new XYZ().new ABC().s);
    }
}
//27) What will be the output of the below program?

//inner XYZ
//но если у XYZ во внутреннем классе ABC дописать String s = "test" то будет ее затягивать в sout