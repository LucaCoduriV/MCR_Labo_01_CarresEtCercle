package game;

import UI.FilledRenderer;
import UI.Renderer;

import java.awt.*;

public class FilledShapeFactory extends BouncableFactory{
    private FilledShapeFactory(){
        renderer = new FilledRenderer();
    }

    @Override
    public Bouncable createCircle() {
        return new Circle(renderer, Color.BLUE, 5);
    }

    @Override
    public Bouncable createSquare() {
        return new Square(renderer, Color.YELLOW, 10);
    }
}
