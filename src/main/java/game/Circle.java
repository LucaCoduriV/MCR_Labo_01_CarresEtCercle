package game;

import UI.Displayer;
import UI.MainWindow;
import UI.Renderer;
import utility.Vector;

import java.awt.*;
import java.awt.geom.Ellipse2D;

class Circle extends BShape {

    final private int radius;

    /**
     * Create a new circle
     * 
     * @param renderer  The renderer to draw the shape
     * @param displayer The displayer to draw the shape
     * @param color     The color of the shape
     * @param position  The position of the shape
     * @param movement  The movement of the shape
     * @param radius    The radius of the circle
     */
    public Circle(Renderer renderer, Displayer displayer, Color color, Vector position, Vector movement, int radius) {
        super(renderer, displayer, color, position, movement);
        this.radius = radius;
    }

    @Override
    public void move() {
        reactOnCollision(radius, radius);
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getPosition().getX(), getPosition().getY(), radius, radius);
    }
}
