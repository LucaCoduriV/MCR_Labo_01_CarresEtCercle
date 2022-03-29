package game;

import UI.Displayer;
import UI.Renderer;
import utility.Vector;

import java.awt.*;
import java.awt.geom.Ellipse2D;

class Square extends BShape {
    private int size;

    public Square(Renderer renderer, Displayer displayer, Color color, Vector position, Vector movement, int size) {
        super(renderer, displayer, color, position, movement);
        this.size = size;
    }

    @Override
    public void move() {
        reactOnCollision(size, size);
    }

    @Override
    public Shape getShape() {
        return new Rectangle(getPosition().getX(), getPosition().getY(), size, size);
    }
}
