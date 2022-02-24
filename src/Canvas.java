import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends java.awt.Canvas {
    private List<Drawable> drawables = new ArrayList<>();

    public Canvas() {
        drawables.add(new Circle(10, Color.BLUE, new Vector(10, 10)));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Drawable d : drawables)
            d.draw(g);
    }
}
