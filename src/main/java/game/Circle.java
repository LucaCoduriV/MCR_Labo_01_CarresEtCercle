package game;

import UI.MainWindow;
import UI.Renderer;
import utility.Vector;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends BShape {

    private int radius;

    public Circle(Renderer renderer, Color color, Vector position, Vector movement, int radius) {
        super(renderer, color, position, movement);
        this.radius = radius;
    }

    @Override
    public void move() {
        //TODO décommenter
        MainWindow mainWindow = MainWindow.getInstance();
        reactOnCollision(mainWindow.getWidth(), mainWindow.getHeight(), radius, radius);
    }

    // TODO appliquer l'offset au dessin et pas au reactOnCollision ?
    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getPosition().getX(), getPosition().getY(), radius, radius);
    }
}
