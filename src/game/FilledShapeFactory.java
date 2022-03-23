package game;

import UI.FilledRenderer;
import UI.Renderer;
import utility.Vector;

import java.awt.*;

public class FilledShapeFactory extends BouncableFactory{
    private static FilledShapeFactory instance;

    public static FilledShapeFactory getInstance(){
        if(instance == null){
            instance = new FilledShapeFactory();
        }
        return instance;
    }

    private FilledShapeFactory(){
        renderer = new FilledRenderer();
    }

    @Override
    public Bouncable createCircle() {
        return new Circle(renderer, Color.BLUE, new Vector(0, 0), getShapesVelocity(), getShapeSize());
    }

    @Override
    public Bouncable createSquare() {
        return new Square(renderer, Color.YELLOW, new Vector(0, 0), getShapesVelocity(), getShapeSize());
    }
}
