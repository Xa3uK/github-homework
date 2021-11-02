package lesson11.classes.init;

public class InitField
{
    protected static String staticField;
    protected String field;

    static {
        staticField = "Static test";
        System.out.println("Static init:" + staticField);
    }

    {
        field = "Test";
        System.out.println("Object init:" + field);
    }

    public static void main(String[] args)
    {
        InitFieldTwo init2 = new InitFieldTwo();
        System.out.println(init2.field);
    }
}
