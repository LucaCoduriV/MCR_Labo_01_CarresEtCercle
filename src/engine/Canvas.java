package engine;

import game.*;
import utility.Vector;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.Timer;

public class Canvas extends JPanel implements ActionListener {
    private List<DrawableObject> drawables = new ArrayList<>();

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
        NB_CIRCLES = 15;
        NB_SQUARES = 15;

        MAX_SIZE = 30;
        MIN_SIZE = 10;

        MAX_MOVEMENT = 4;
        MIN_MOVEMENT = 1;

        initCircles();
        initSquares();
    }

    private void initCircles() {
        for (int i = 0; i < NB_CIRCLES; i++) {
            Random random = new Random();

            final int RADIUS = random.nextInt(MAX_SIZE / 2 - MIN_SIZE / 2) + MIN_SIZE / 2;
            final int MOVE_X = random.nextInt((MAX_MOVEMENT - MIN_MOVEMENT) * 2) - MIN_MOVEMENT;
            final int MOVE_Y = random.nextInt((MAX_MOVEMENT - MIN_MOVEMENT) * 2) - MIN_MOVEMENT;

            drawables.add(new DCircle(RADIUS, CIRCLE_COLOR, new Vector(RADIUS, RADIUS), new Vector(MOVE_X, MOVE_Y)));
        }
    }

    private void initSquares() {
        for (int i = 0; i < NB_SQUARES; i++) {
            Random random = new Random();

            final int SIZE = random.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE;
            final int MOVE_X = random.nextInt((MAX_MOVEMENT - MIN_MOVEMENT) * 2) - MIN_MOVEMENT;
            final int MOVE_Y = random.nextInt((MAX_MOVEMENT - MIN_MOVEMENT) * 2) - MIN_MOVEMENT;

            drawables.add(new DSquare(SIZE, SQUARE_COLOR, new Vector(SIZE / 2, SIZE / 2), new Vector(MOVE_X, MOVE_Y)));
        }
    }

    public void startUpdate() {
        Timer timer = new Timer(1000/60, this);

        timer.start();
    }

    public void update() {
        for (DrawableObject d : drawables)
            d.update(getWidth(), getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable d : drawables) {
            d.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }
}
