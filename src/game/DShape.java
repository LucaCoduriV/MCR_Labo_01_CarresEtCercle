package game;

import graphics.Displayer;
import graphics.DrawableObject;
import utility.Vector;

import java.awt.*;

public abstract class DShape extends DrawableObject {

    public DShape(Color color, Vector position, Vector movement, Displayer displayer) {
        super(color, position, movement, displayer);
    }

    public void reactOnCollision(int maxX, int maxY, int offsetX, int offsetY) {
        Vector newPosition = getPosition().add(getMovement());

        if ((newPosition.getX() + offsetX) >= maxX || (newPosition.getX()) <= 0) {
            setMovement(new Vector(-getMovement().getX(), getMovement().getY()));
        }

        if ((newPosition.getY() + offsetY) >= maxY || (newPosition.getY()) <= 0) {
            setMovement(new Vector(getMovement().getX(), -getMovement().getY()));
        }

        setPosition(getPosition().add(getMovement()));
    }
}
