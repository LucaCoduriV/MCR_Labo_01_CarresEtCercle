package game;

import UI.Displayer;
import UI.Renderer;
import utility.Vector;

import java.awt.*;

abstract class BShape implements Bouncable {
    private Renderer renderer;
    private Displayer displayer;
    private final Color COLOR;
    private Vector position;
    private Vector movement;

    protected BShape(Renderer renderer, Displayer displayer, Color color, Vector position, Vector movement) {
        this.renderer = renderer;
        this.displayer = displayer;
        this.COLOR = color;
        this.position = position;
        this.movement = movement;
    }

    @Override
    public void draw() {
        renderer.display(displayer.getGraphics(), this);
    }

    @Override
    public Color getColor() {
        return COLOR;
    }

    protected void reactOnCollision(int offsetX, int offsetY) {
        Vector newPosition = position.add(movement);

        if ((newPosition.getX() + offsetX) >= displayer.getWidth() || (newPosition.getX()) <= 0) {
            movement = new Vector(-movement.getX(), movement.getY());
        }

        if ((newPosition.getY() + offsetY) >= displayer.getHeight() || (newPosition.getY()) <= 0) {
            movement = new Vector(movement.getX(), -movement.getY());
        }

        position = position.add(movement);
    }

    public Vector getPosition() {
        return position;
    }
}
