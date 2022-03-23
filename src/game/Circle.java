package game;

import UI.Renderer;
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
        //TODO décommenter
        //reactOnCollision(MainWindow.getInstance().getWidth(), MainWindow.getInstance().getHeight(), size, size);
    }

    @Override
    public Shape getShape() {
        return new Rectangle(size, size);
    }
}
