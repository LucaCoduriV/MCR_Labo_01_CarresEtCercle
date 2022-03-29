package game;

import java.awt.*;

public interface Bouncable {
    /**
     * Draws the boucable object on the displayer
     */
    void draw();

    /**
     * Move the boucable object 
     */
    void move();

    /**
     * @return the object's color
     */
    Color getColor();

    /**
     * @return the object's shape
     */
    Shape getShape();
}
