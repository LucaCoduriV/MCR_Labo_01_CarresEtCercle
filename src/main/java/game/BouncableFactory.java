package game;

import UI.MainWindow;
import UI.Renderer;
import utility.Vector;

import java.util.Random;

public abstract class BouncableFactory {
    private static Random rnd = new Random();
    private static final int SHAPES_SIZE_RANGE = 60;
    private static final int SHAPES_VELOCITY_RANGE = 30;
    protected Renderer renderer;
    /**
     * Generate a random shape size
     * 
     * @return The size of the shape.
     */
    protected int getShapeSize(){
        return 1 + rnd.nextInt(SHAPES_SIZE_RANGE - 1 );
    }
    /**
     * Generate a random velocity vector for the shapes
     * 
     * @return The velocity of the shapes.
     */
    protected Vector getShapesVelocity(){
        return new Vector(-SHAPES_VELOCITY_RANGE + rnd.nextInt(2 * SHAPES_VELOCITY_RANGE),
                -SHAPES_VELOCITY_RANGE + rnd.nextInt(2 * SHAPES_VELOCITY_RANGE));
    }
    /**
     * Generate a random position for the shape
     * 
     * @return A vector.
     */
    protected Vector getShapePosition(){
        MainWindow window = MainWindow.getInstance();
        return new Vector(rnd.nextInt(window.getWidth()), rnd.nextInt(window.getHeight()));
    }

    public abstract Bouncable createCircle();
    public abstract Bouncable createSquare();
}
