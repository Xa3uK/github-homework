package lesson11.move;

import javax.swing.*;

public class MoveSquare
{
    public static void main(String[] args)
    {
        // Создаем графическое окно
        MoveSquareFrame msf = new MoveSquareFrame();
        // Задаем правидо, по которому приложение завершиться при
        // закрытии этой формы
        msf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Делаем окно видимым
        msf.setVisible(true);
    }
}
