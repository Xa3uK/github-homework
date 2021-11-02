package lesson11.move;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquareComponent extends JComponent implements ActionListener
{
    // Определяем константу для размера квадрата
    private static final int SQUARE_SIZE = 30;
    // Определяем константу для шага
    private static final int STEP = 10;
    // Определяем поля для хранения текущих координат квадрата
    private int x = 0;
    private int y = 0;

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Входной параметр содержит ссылку на того, кто послал сообщение.
        // Получает объект с помощью вызова getSource()
        // С помощью слова instanceof мы можем проверить, что объект принадлежит
        // классу JButton (или его потомку)
        if (e.getSource() instanceof JButton) {
            // Приводим объект к типу JButton
            JButton btn = (JButton) e.getSource();
            // Сравниваем команду со строкой UP
            if (MoveSquareFrame.UP.equals(btn.getActionCommand())) {
                // Вверх двигаемся уменьшением координаты Y
                y -= STEP;
            }
            // Сравниваем команду со строкой DOWN
            if (MoveSquareFrame.DOWN.equals(btn.getActionCommand())) {
                // Вниз двигаемся увеличением координаты Y
                y += STEP;
            }

            if (MoveSquareFrame.RIGHT.equals(btn.getActionCommand())) {
                // Вниз двигаемся увеличением координаты Y
                x += STEP;
            }

            if (MoveSquareFrame.LEFT.equals(btn.getActionCommand())) {
                // Вниз двигаемся увеличением координаты Y
                x -= STEP;
            }
            // Перерисовываем компонент для обновления экрана
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
    }
}
