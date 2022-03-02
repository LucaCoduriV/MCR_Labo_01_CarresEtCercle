package game;

import java.awt.*;
import utility.*;

public class DRectangle extends DShape {
    private int width;
    private int height;

    public DRectangle(int width, int height, Color color, Vector position, Vector movement) {
        super(color, position, movement);
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getPosition().getX(), getPosition().getY(), width, height);
    }
}
