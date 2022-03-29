package game;

import UI.MainWindow;
import UI.Renderer;
import utility.Vector;

import java.awt.*;
// TODO public ?
public abstract class BShape implements Bouncable {
    private Renderer renderer;
    private final Color COLOR;
    private Vector position;
    private Vector movement;

    protected BShape(Renderer renderer, Color color, Vector position, Vector movement) {
        this.renderer = renderer;
        this.COLOR = color;
        this.position = position;
        this.movement = movement;
    }

    @Override
    public void draw() {
        MainWindow main = MainWindow.getInstance();
        renderer.display(main.getGraphics(), this);
    }

    @Override
    public Color getColor() {
        return COLOR;
    }

    // TODO rename + est-ce que c'est pas mieux de pas avoir les bounds en paramètre ?
    // TODO public ?
    public void reactOnCollision(int maxX, int maxY, int offsetX, int offsetY) {
        Vector newPosition = position.add(movement);

        if ((newPosition.getX() + offsetX) >= maxX || (newPosition.getX()) <= 0) {
            movement = new Vector(-movement.getX(), movement.getY());
        }

        if ((newPosition.getY() + offsetY) >= maxY || (newPosition.getY()) <= 0) {
            movement = new Vector(movement.getX(), -movement.getY());
        }

        position = position.add(movement);
    }

    public Vector getPosition() {
        return position;
    }
}
