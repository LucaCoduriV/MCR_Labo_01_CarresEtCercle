import graphics.Drawable;
import graphics.DrawableObject;
import graphics.MainWindow;
import game.DCircle;
import game.DShape;
import game.DSquare;
import utility.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static Color CIRCLE_COLOR;
    private static Color SQUARE_COLOR;
    private static int NB_CIRCLES;
    private static int NB_SQUARES;
    // TODO laisser ici ?
    private static int MAX_SIZE;
    private static int MIN_SIZE;

    private static int MAX_MOVEMENT;
    private static int MIN_MOVEMENT;

    public static void main(String[] args) {
        CIRCLE_COLOR = Color.BLUE;
        SQUARE_COLOR = Color.ORANGE;
        NB_CIRCLES = 15;
        NB_SQUARES = 15;

        MAX_SIZE = 30;
        MIN_SIZE = 10;

        MAX_MOVEMENT = 4;
        MIN_MOVEMENT = 1;


        List<DShape> shapes = new ArrayList<>();
        MainWindow mainWindow = MainWindow.getInstance();

        for (int i = 0; i < NB_CIRCLES; i++) {
            Random random = new Random();

            final int RADIUS = random.nextInt(MAX_SIZE / 2 - MIN_SIZE / 2) + MIN_SIZE / 2;
            final int MOVE_X = random.nextInt((MAX_MOVEMENT - MIN_MOVEMENT) * 2) - MIN_MOVEMENT;
            final int MOVE_Y = random.nextInt((MAX_MOVEMENT - MIN_MOVEMENT) * 2) - MIN_MOVEMENT;

            shapes.add(new DCircle(RADIUS, CIRCLE_COLOR, new Vector(RADIUS, RADIUS), new Vector(MOVE_X, MOVE_Y),mainWindow));
        }

        for (int i = 0; i < NB_SQUARES; i++) {
            Random random = new Random();

            final int SIZE = random.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE;
            final int MOVE_X = random.nextInt((MAX_MOVEMENT - MIN_MOVEMENT) * 2) - MIN_MOVEMENT;
            final int MOVE_Y = random.nextInt((MAX_MOVEMENT - MIN_MOVEMENT) * 2) - MIN_MOVEMENT;

            shapes.add(new DSquare(SIZE, SQUARE_COLOR, new Vector(SIZE / 2, SIZE / 2), new Vector(MOVE_X, MOVE_Y), mainWindow));
        }




        Timer timer = new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainWindow.repaint();

                for (DrawableObject d : shapes)
                    d.update();

                for (Drawable d : shapes) {
                    d.draw();
                }

            }
        });

        timer.start();

    }
}
