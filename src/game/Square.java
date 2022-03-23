package game;

import UI.Renderer;
import utility.Vector;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Square extends BShape {
    private int radius;

    public Square(Renderer renderer, Color color, Vector position, Vector movement, int radius) {
        super(renderer, color, position, movement);
        this.radius = radius;
    }

    @Override
    public void move() {
        //TODO décommenter
        //reactOnCollision(MainWindow.getInstance().getWidth(), MainWindow.getInstance().getHeight(), size, size);
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(radius, radius, radius, radius);
    }
}
