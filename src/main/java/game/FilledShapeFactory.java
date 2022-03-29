package game;

import UI.Displayer;
import UI.FilledRenderer;

import java.awt.*;

public class FilledShapeFactory extends BouncableFactory{
    private static FilledShapeFactory instance;

    /**
     * Create a new FilledShapeFactory if it doesn't exist
     * @return the FilledShapeFactory
     */
    public static FilledShapeFactory getInstance(){
        if(instance == null){
            instance = new FilledShapeFactory();
        }
        return instance;
    }

    /**
     * Create a new factory with a filled renderer
     */
    private FilledShapeFactory(){
        renderer = new FilledRenderer();
    }

    @Override
    public Bouncable createCircle(Displayer displayer) {
        return new Circle(renderer, displayer, Color.BLUE, getShapePosition(), getShapesVelocity(), getShapeSize());
    }

    @Override
    public Bouncable createSquare(Displayer displayer) {
        return new Square(renderer, displayer, Color.YELLOW, getShapePosition(), getShapesVelocity(), getShapeSize());
    }
}
