package game;

import graphics.Displayer;
import utility.Vector;

import java.awt.*;

public class DCircle extends DShape {
    private int radius;

    public DCircle(int radius, Color color, Vector position, Vector movement, Displayer displayer) {
        super(color, position, movement, displayer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        Graphics graphics = getDisplayer().getGraphics();
        graphics.setColor(getColor());
        graphics.fillOval(getPosition().getX(), getPosition().getY(), 2 * radius, 2 * radius);
    }

    @Override
    public void update() {
        reactOnCollision(getDisplayer().getWidth(), getDisplayer().getHeight(), radius * 2, radius * 2);
    }
}
