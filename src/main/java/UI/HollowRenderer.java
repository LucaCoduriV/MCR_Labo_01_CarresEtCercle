package UI;

import game.Bouncable;

import java.awt.*;

public class HollowRenderer implements Renderer{
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.draw(b.getShape());
    }
}
