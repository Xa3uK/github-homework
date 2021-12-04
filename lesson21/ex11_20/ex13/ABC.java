package lesson21.ex11_20.ex13;

class ABC {
    int i = 10101;

    {
        i--;
    }

    public ABC() {
        --i;
    }

    class XYZ {
        int i = this.i;

        {
            i++;
        }

        public XYZ() {
            ++i;
        }
    }
}

class MainClass {
    public static void main(String[] args) {
        ABC abc = new ABC();

        System.out.println(abc.i);

        ABC.XYZ xyz = abc.new XYZ();

        System.out.println(xyz.i);

        ABC.XYZ xyz1 = new ABC().new XYZ();

        System.out.println(xyz1.i);
    }
}
//13) What will be the output of the following program?

//10099  - два декремента
//2  - здесь переменная сама на себя ссылается получается при инициализации, и по дефолту = 0 , затем два инкремента
//2  - здесь переменная сама на себя ссылается получается при инициализации, и по дефолту = 0 , затем два инкремента


