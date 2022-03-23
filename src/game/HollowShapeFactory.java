package game;

import UI.HollowRender;
import UI.Renderer;
import utility.Vector;

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
        renderer = new HollowRender();
    }

    @Override
    public Bouncable createCircle() {
        return new Circle(renderer, Color.green, new Vector(0, 0), new Vector(1, 2), 5);
    }

    @Override
    public Bouncable createSquare() {
        return new Square(renderer, Color.red, new Vector(0, 0), new Vector(1, 2), 10);
    }
}
