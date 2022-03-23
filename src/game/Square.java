package game;

import UI.Renderer;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Square extends BShape {
    private int radius;

    public Square(Renderer renderer, Color color, int radius) {
        super(renderer, color);
        this.radius = radius;
    }

    @Override
    public void move() {

    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(radius, radius, radius, radius);
    }
}
