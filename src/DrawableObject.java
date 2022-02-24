import java.awt.*;

public abstract class DrawableObject implements Drawable {
    private Color color;
    private Vector position;
    
    protected DrawableObject(Color color, Vector position) {
        this.color = color;
        this.position = position;
    }

    public Vector getPosition() {
        return position;
    }
}
