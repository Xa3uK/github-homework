package lesson21.ex31_40.ex37;

interface I {
    String name = "III";

    void printName();
}

class C {
    String name = "CCC";

    static {
        new I() {
            public void printName() {
                System.out.println(name);
            }
        }.printName();
    }

    {
        System.out.println(name);
    }
}

class MainClass {
    public static void main(String[] args) {
        C c = new C();
    }
}
//37) What will be the output of the following program?

//iii
//ccc

//        сначало статика при создании объекта С (интерфейс тянет свое имя), потом нон статик блок, С тянет свое имя
