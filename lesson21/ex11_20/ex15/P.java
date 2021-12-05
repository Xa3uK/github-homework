package lesson21.ex11_20.ex15;

class P {
    String s = "PPP";

    {
        System.out.println(s);
    }

    String methodP() {
        class Q {
            String s = P.this.s + "QQQ";

            {
                System.out.println(s);
            }
        }
        return new Q().s + s;
    }
}

class MainClass {
    public static void main(String[] args) {
        P p = new P();
        System.out.println(p.methodP());
    }
}

//ppp   - не статика переменная внешнего класса
//pppqqq  - в процессе метода складывается строка внешнего класса + добавка,
//                  присваевается внутренней переменной и саутится в консоль
//pppqqqppp  - к результату предыдущего действия добавляется переменная внешнего класса
