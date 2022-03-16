package game;

public class HollowShapeFactory extends BouncableFactory{
    private HollowShapeFactory(){}

    @Override
    Bouncable createCircle() {
        return null;
    }

    @Override
    Bouncable createSquare() {
        return null;
    }
}
