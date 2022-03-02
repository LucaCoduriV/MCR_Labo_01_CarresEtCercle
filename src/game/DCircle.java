package game;

import utility.Vector;

import java.awt.*;

public class DCircle extends DShape {
    private int radius;

    public DCircle(int radius, Color color, Vector position, Vector movement) {
        super(color, position, movement);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getPosition().getX(), getPosition().getY(), 2 * radius, 2 * radius);
    }
}
