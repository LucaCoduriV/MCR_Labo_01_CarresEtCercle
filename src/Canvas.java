import java.awt.*;
import java.util.*;
import java.util.List;

public class Canvas extends java.awt.Canvas {
    private List<Drawable> drawables = new ArrayList<>();

    private final Color CIRCLE_COLOR;
    private final Color SQUARE_COLOR;
    private final int NB_CIRCLES;
    private final int NB_SQUARES;
    // TODO laisser ici ?
    private final int MAX_SIZE;
    private final int MIN_SIZE;

    private final int MAX_MOVEMENT;
    private final int MIN_MOVEMENT;


    public Canvas() {
        CIRCLE_COLOR = Color.BLUE;
        SQUARE_COLOR = Color.ORANGE;
        NB_CIRCLES = 5;
        NB_SQUARES = 5;

        MAX_SIZE = 50;
        MIN_SIZE = 10;

        MAX_MOVEMENT = 5;
        MIN_MOVEMENT = 1;

        initCircles();
        initSquares();
    }

    private void initCircles() {
        for (int i = 0; i < NB_CIRCLES; i++) {
            Random random = new Random();

            final int RADIUS = random.nextInt(MAX_SIZE / 2 - MIN_SIZE / 2) + MIN_SIZE / 2;
            final int MOVE_X = random.nextInt(MAX_MOVEMENT - MIN_MOVEMENT) + MIN_MOVEMENT;
            final int MOVE_Y = random.nextInt(MAX_MOVEMENT - MIN_MOVEMENT) + MIN_MOVEMENT;

            drawables.add(new DCircle(RADIUS, CIRCLE_COLOR, new Vector(0, 0), new Vector(MOVE_X, MOVE_Y)));
        }
    }

    private void initSquares() {
        for (int i = 0; i < NB_SQUARES; i++) {
            Random random = new Random();

            final int SIZE = random.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE;
            final int MOVE_X = random.nextInt(MAX_MOVEMENT - MIN_MOVEMENT) + MIN_MOVEMENT;
            final int MOVE_Y = random.nextInt(MAX_MOVEMENT - MIN_MOVEMENT) + MIN_MOVEMENT;

            drawables.add(new DSquare(SIZE, SQUARE_COLOR, new Vector(0, 0), new Vector(MOVE_X, MOVE_Y)));
        }
    }

    public void startMove () {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                move();
                paint(getGraphics());
            }
        }, 0, 100);
    }

    public void move () {
        for (Drawable d : drawables)
            d.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Drawable d : drawables) {
            d.draw(g);
        }
    }
}
