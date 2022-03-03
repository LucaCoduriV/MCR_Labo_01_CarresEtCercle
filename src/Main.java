import graphics.Displayer;
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
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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


        try{
            createShapeRandomly(DCircle.class,CIRCLE_COLOR, NB_CIRCLES, mainWindow, shapes);
            createShapeRandomly(DSquare.class,SQUARE_COLOR, NB_SQUARES, mainWindow, shapes);
        }catch(Exception e){
            System.out.println(e);
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

    static void createShapeRandomly(Class shape,Color color, int quantity, Displayer window, List<DShape> shapes) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Random random = new Random();

        for (int i = 0; i < quantity; i++) {

            final int SIZE = random.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE;
            final int MOVE_X = random.nextInt((MAX_MOVEMENT - MIN_MOVEMENT) * 2) - MIN_MOVEMENT;
            final int MOVE_Y = random.nextInt((MAX_MOVEMENT - MIN_MOVEMENT) * 2) - MIN_MOVEMENT;

            Constructor constr = shape.getDeclaredConstructor(int.class,
                    Color.class,
                    Vector.class,
                    Vector.class,
                    Displayer.class);

            shapes.add((DShape) constr.newInstance(SIZE, color, new Vector(SIZE, SIZE), new Vector(MOVE_X, MOVE_Y), window));

        }
    }
}
