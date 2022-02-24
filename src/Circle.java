import java.awt.*;

public class Circle extends DrawableObject {
    private int radius;

    public Circle(int radius, Color color, Vector position) {
        super(color, position);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(getPosition().getX(), getPosition().getY(), 2 * radius, 2 * radius);
    }
}
