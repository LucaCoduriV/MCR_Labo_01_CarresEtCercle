package game;

public class HollowShapeFactory extends BouncableFactory{
    private HollowShapeFactory(){}

    @Override
    Bouncable createCircle() {
        return new Circle();
    }

    @Override
    Bouncable createSquare() {
        return new Square();
    }
}
