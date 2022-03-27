package UI;

import game.Bouncable;

import java.awt.*;

public class FilledRenderer implements Renderer {
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.fill(b.getShape());
        g.draw(b.getShape());
    }
}
