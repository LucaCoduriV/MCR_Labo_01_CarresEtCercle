package game;

import utility.Vector;

import java.awt.*;

public class DSquare extends DShape {
    private int size;

    public DSquare(int size, Color color, Vector position, Vector movement) {
        super(color, position, movement);
        this.size = size;
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getPosition().getX(), getPosition().getY(), size, size);
    }

    @Override
    public void update(int maxX, int maxY) {
        reactOnCollision(maxX, maxY, size, size);
    }
}
