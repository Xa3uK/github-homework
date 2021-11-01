package lesson11.simpleFrame.component.shapeApp2;

import java.awt.*;

public class RectangleComponent extends AbstractShape
{
    @Override
    protected void paintShape(Graphics g) {
        g.drawRect(5, 5, getWidth() - 10, getHeight() - 10);
    }
}

