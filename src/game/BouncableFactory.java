package game;

import UI.Renderer;
import utility.Singleton;

public abstract class BouncableFactory extends Singleton {
    Renderer renderer;
    public abstract Bouncable createCircle();
    public abstract Bouncable createSquare();
}
