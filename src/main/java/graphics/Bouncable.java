package graphics;

import UI.Renderer;

import java.awt.*;
// TODO faut tej ça ? regarder l'arbo
public interface Bouncable {
    void draw();
    void move();
    Color getColor();
    Shape getShape();
}
