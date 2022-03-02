package game;

import game.DRectangle;
import utility.Vector;

import java.awt.*;

public class DSquare extends DRectangle {

    public DSquare(int size, Color color, Vector position, Vector movement) {
        super(size, size, color, position, movement);
    }
}
