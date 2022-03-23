package game;

import UI.MainWindow;
import UI.Renderer;
import utility.Singleton;
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
        MainWindow mainWindow = (MainWindow) Singleton.getInstance();
        reactOnCollision(mainWindow.getWidth(), mainWindow.getHeight(), radius, radius);
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(radius, radius, radius, radius);
    }
}
