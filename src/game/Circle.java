package game;

import UI.Renderer;

import java.awt.*;

public class Circle extends BShape {
    private int size;

    public Circle(Renderer renderer, Color color, int size) {
        super(renderer, color);
        this.size = size;
    }

    @Override
    public void move() {

    }

    @Override
    public Shape getShape() {
        return new Rectangle(size, size);
    }
}
