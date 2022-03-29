package game;

import UI.Displayer;
import UI.Renderer;
import utility.Vector;

import java.awt.*;
import java.awt.geom.Ellipse2D;

class Square extends BShape {
    private int size;

    /**
     * Create a new square
     * 
     * @param renderer  The renderer to draw the shape
     * @param displayer The displayer to draw the shape
     * @param color     The color of the shape
     * @param position  The position of the shape
     * @param movement  The movement of the shape
     * @param size      The size of the square
     */
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
