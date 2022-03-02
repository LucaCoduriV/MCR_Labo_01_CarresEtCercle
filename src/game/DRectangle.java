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

    @Override
    public void update(int maxX, int maxY) {
        Vector newPosition = getPosition().add(getMovement());

        if ((newPosition.getX() + width) >= maxX || (newPosition.getX()) <= 0) {
            setMovement(new Vector(-getMovement().getX(), getMovement().getY()));
        }

        if ((newPosition.getY() + height) >= maxY || (newPosition.getY()) <= 0) {
            setMovement(new Vector(getMovement().getX(), -getMovement().getY()));
        }

        setPosition(getPosition().add(getMovement()));
    }
}
