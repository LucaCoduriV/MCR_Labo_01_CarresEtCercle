package game;

import UI.MainWindow;
import UI.Renderer;
import utility.Singleton;
import utility.Vector;

import java.awt.*;

public class Circle extends BShape {
    private int size;

    public Circle(Renderer renderer, Color color, Vector position, Vector movement, int size) {
        super(renderer, color, position, movement);
        this.size = size;
    }

    @Override
    public void move() {
        MainWindow mainWindow = (MainWindow) Singleton.getInstance();
        reactOnCollision(mainWindow.getWidth(), mainWindow.getHeight(), size, size);
    }

    @Override
    public Shape getShape() {
        return new Rectangle(size, size);
    }
}
