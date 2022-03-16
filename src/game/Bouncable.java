package game;

import java.awt.*;

public interface Bouncable {
    void draw();
    void move();
    Color getColor();
    BShape getShape();
}
