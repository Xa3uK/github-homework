package lesson11.simpleFrame;

import javax.swing.*;
import java.awt.*;

public class OvalComponent extends JComponent {

    // Переопределяем метод рисованиая, в который передается
    // объект класса Graphics
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Используем Graphics для рисования овала
        // с отступами
        g.drawOval(5, 5, getWidth() - 10, getHeight() - 10);
    }
}

