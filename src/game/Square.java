package game;

import UI.MainWindow;
import UI.Renderer;
import utility.Vector;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Square extends BShape {
    private int size;

    public Square(Renderer renderer, Color color, Vector position, Vector movement, int size) {
        super(renderer, color, position, movement);
        this.size = size;
    }

    @Override
    public void move() {
        MainWindow mainWindow = MainWindow.getInstance();
        reactOnCollision(mainWindow.getWidth(), mainWindow.getHeight(), size, size);
    }

    @Override
    public Shape getShape() {
        return new Rectangle(getPosition().getX(), getPosition().getY(), size, size);
    }
}
