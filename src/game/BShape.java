package game;

import UI.MainWindow;
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
        MainWindow main = (MainWindow) MainWindow.getInstance();
        renderer.display(main.getGraphics(), this);
    }

    @Override
    public Color getColor() {
        return COLOR;
    }
}
