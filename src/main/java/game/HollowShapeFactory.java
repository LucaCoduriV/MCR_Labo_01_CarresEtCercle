package game;

import UI.Displayer;
import UI.HollowRenderer;

import java.awt.*;

public class HollowShapeFactory extends BouncableFactory{
    private static HollowShapeFactory instance;

    public static HollowShapeFactory getInstance() {
        if(instance == null){
            instance = new HollowShapeFactory();
        }
        return instance;
    }

    private HollowShapeFactory(){
        renderer = new HollowRenderer();
    }

    @Override
    public Bouncable createCircle(Displayer displayer) {
        return new Circle(renderer, displayer, Color.green, getShapePosition(), getShapesVelocity(), getShapeSize());
    }

    @Override
    public Bouncable createSquare(Displayer displayer) {
        return new Square(renderer, displayer, Color.red, getShapePosition(), getShapesVelocity(), getShapeSize());
    }
}
