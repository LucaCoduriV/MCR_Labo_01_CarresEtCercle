import java.awt.*;

public class Rectangle extends DrawableObject {
    private int width;
    private int height;

    public Rectangle(int width, int height, Color color, Vector position) {
        super(color, position);
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {

    }
}
