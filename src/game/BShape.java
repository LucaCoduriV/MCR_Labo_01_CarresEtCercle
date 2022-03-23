package game;

import UI.Renderer;

import java.awt.*;

public abstract class BShape implements Bouncable{
    private Renderer renderer = null;
    private final Color COLOR;

    protected BShape(Renderer renderer, Color color) {
        this.renderer = renderer;
        this.COLOR = color;
    }

    @Override
    public void draw() {
        // TODO décommenter
        //renderer.display(MainWindow.getInstance().getGraphics(), this);
    }

    @Override
    public Color getColor() {
        return COLOR;
    }
}
