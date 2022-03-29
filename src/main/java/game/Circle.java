package game;

import UI.Displayer;
import UI.MainWindow;
import UI.Renderer;
import utility.Vector;

import java.awt.*;
import java.awt.geom.Ellipse2D;

class Circle extends BShape {

    private int radius;

    public Circle(Renderer renderer, Displayer displayer, Color color, Vector position, Vector movement, int radius) {
        super(renderer, displayer, color, position, movement);
        this.radius = radius;
    }

    @Override
    public void move() {
        MainWindow mainWindow = MainWindow.getInstance();
        reactOnCollision(radius, radius);
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getPosition().getX(), getPosition().getY(), radius, radius);
    }
}
