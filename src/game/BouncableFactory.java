package game;

import UI.Renderer;

public abstract class BouncableFactory {
    Renderer renderer;
    public abstract Bouncable createCircle();
    public abstract Bouncable createSquare();
}
