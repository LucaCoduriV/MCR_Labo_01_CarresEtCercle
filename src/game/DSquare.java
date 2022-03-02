package game;

import graphics.Displayer;
import utility.Vector;

import java.awt.*;

public class DSquare extends DShape {
    private int size;

    public DSquare(int size, Color color, Vector position, Vector movement, Displayer displayer) {
        super(color, position, movement, displayer);
        this.size = size;
    }

    public void draw() {
        Graphics graphics = getDisplayer().getGraphics();
        graphics.setColor(getColor());
        graphics.fillRect(getPosition().getX(), getPosition().getY(), size, size);
    }

    @Override
    public void update() {
        reactOnCollision(getDisplayer().getWidth(), getDisplayer().getHeight(), size, size);
    }
}
