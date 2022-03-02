package engine;

import engine.Drawable;

import java.awt.*;
import utility.*;

public abstract class DrawableObject implements Drawable {
    private final Color COLOR;
    private Vector position;
    private Vector movement;
    
    protected DrawableObject(Color color, Vector position, Vector movement) {
        this.COLOR = color;
        this.position = position;
        this.movement = movement;
    }

    public Vector getPosition() {
        return position;
    }

    public Color getColor() {
        return COLOR;
    }

    public Vector getMovement() {
        return movement;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public void setMovement(Vector movement) {
        this.movement = movement;
    }

    public abstract void update(int maxX, int maxY);
}
