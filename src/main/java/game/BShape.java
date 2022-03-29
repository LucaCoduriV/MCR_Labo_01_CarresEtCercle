package game;

import UI.Displayer;
import UI.Renderer;
import utility.Vector;

import java.awt.*;

abstract class BShape implements Bouncable {
    private Renderer renderer;
    private Displayer displayer;
    private final Color COLOR;
    private Vector position;
    private Vector movement;

    /**
     * Create a new shape
     * 
     * @param renderer The renderer to draw the shape
     * @param displayer The displayer to draw the shape
     * @param color The color of the shape
     * @param position The position of the shape
     * @param movement The movement of the shape
     */
    protected BShape(Renderer renderer, Displayer displayer, Color color, Vector position, Vector movement) {
        this.renderer = renderer;
        this.displayer = displayer;
        this.COLOR = color;
        this.position = position;
        this.movement = movement;
    }

    @Override
    public void draw() {
        renderer.display(displayer.getGraphics(), this);
    }

    @Override
    public Color getColor() {
        return COLOR;
    }

    /**
     * Update the position of the shape according to the movement and the
     * displayer's size
     * 
     * @param offsetX The offset of the shape in the x axis
     * @param offsetY The offset of the shape in the y axis
     */
    protected void reactOnCollision(int offsetX, int offsetY) {
        Vector newPosition = position.add(movement);

        if ((newPosition.getX() + offsetX) >= displayer.getWidth() || (newPosition.getX()) <= 0) {
            movement = new Vector(-movement.getX(), movement.getY());
        }

        if ((newPosition.getY() + offsetY) >= displayer.getHeight() || (newPosition.getY()) <= 0) {
            movement = new Vector(movement.getX(), -movement.getY());
        }

        position = position.add(movement);
    }

    /**
     * @return The position of the shape
     */
    public Vector getPosition() {
        return position;
    }
}
