package game;

import engine.DrawableObject;
import utility.Vector;

import java.awt.*;

public abstract class DShape extends DrawableObject {
    public DShape(Color color, Vector position, Vector movement) {
        super(color, position, movement);
    }


}
