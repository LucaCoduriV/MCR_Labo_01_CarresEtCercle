package game;

import engine.DrawableObject;
import utility.Vector;

import java.awt.*;

public abstract class DShape extends DrawableObject {
    public DShape(Color color, Vector position, Vector movement) {
        super(color, position, movement);
    }

    public void update(int maxX, int maxY) {
        Vector newPosition = getPosition().add(getMovement());

        if (newPosition.getX() >= maxX || newPosition.getX() <= 0) {
            setMovement(new Vector(-getMovement().getX(), getMovement().getY()));
        }

        if (newPosition.getY() >= maxY || newPosition.getY() <= 0) {
            setMovement(new Vector(getMovement().getX(), -getMovement().getY()));
        }

        setPosition(getPosition().add(getMovement()));
    }
}
