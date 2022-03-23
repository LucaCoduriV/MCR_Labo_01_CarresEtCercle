package game;

import UI.Renderer;

public class FilledShapeFactory extends BouncableFactory{

    private FilledShapeFactory(){}

    @Override
    Bouncable createCircle() {
        return new Circle();
    }

    @Override
    Bouncable createSquare() {
        return new Square();
    }
}
