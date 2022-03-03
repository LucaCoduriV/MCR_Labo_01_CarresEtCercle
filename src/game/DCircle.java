package game;

import graphics.Displayer;
import utility.Vector;

import java.awt.*;

public class DCircle extends DShape {
    private int diametre;

    public DCircle(int diametre, Color color, Vector position, Vector movement, Displayer displayer) {
        super(color, position, movement, displayer);
        this.diametre = diametre;
    }

    @Override
    public void draw() {
        Graphics graphics = getDisplayer().getGraphics();
        graphics.setColor(getColor());
        graphics.fillOval(getPosition().getX(), getPosition().getY(), diametre, diametre);
    }

    @Override
    public void update() {
        reactOnCollision(getDisplayer().getWidth(), getDisplayer().getHeight(), diametre, diametre);
    }
}
