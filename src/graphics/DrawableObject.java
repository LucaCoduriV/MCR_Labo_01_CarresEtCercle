package graphics;

import java.awt.*;
import utility.*;

public abstract class DrawableObject implements Drawable {
    private Displayer displayer;
    private final Color COLOR;
    private Vector position;
    private Vector movement;
    
    protected DrawableObject(Color color, Vector position, Vector movement, Displayer displayer) {
        this.COLOR = color;
        this.position = position;
        this.movement = movement;
        this.displayer = displayer;
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

    public abstract void update();

    @Override
    public Displayer getDisplayer() {
        return displayer;
    }
}
