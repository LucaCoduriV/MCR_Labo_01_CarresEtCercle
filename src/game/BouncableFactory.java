package game;

import UI.MainWindow;
import UI.Renderer;
import utility.Vector;

import java.util.Random;

public abstract class BouncableFactory {
    private static Random rnd = new Random();
    private static final int SHAPES_SIZE_RANGE = 60;
    private static final int SHAPES_VELOCITY_RANGE = 30;

    protected int getShapeSize(){
        return rnd.nextInt(SHAPES_SIZE_RANGE);
    }
    protected Vector getShapesVelocity(){
        return new Vector(-SHAPES_VELOCITY_RANGE + rnd.nextInt(2 * SHAPES_VELOCITY_RANGE),
                -SHAPES_VELOCITY_RANGE + rnd.nextInt(2 * SHAPES_VELOCITY_RANGE));
    }
    protected Vector getShapePosition(){
        MainWindow window = MainWindow.getInstance();
        return new Vector(rnd.nextInt(window.getWidth()), rnd.nextInt(window.getHeight()));
    }

    Renderer renderer;
    public abstract Bouncable createCircle();
    public abstract Bouncable createSquare();
}
