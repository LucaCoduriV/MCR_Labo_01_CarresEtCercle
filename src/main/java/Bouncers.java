import UI.MainWindow;
import game.Bouncable;
import game.BouncableFactory;
import game.FilledShapeFactory;
import game.HollowShapeFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * Swing Application that draws hollow and filled shapes onto a window.
 * @author Nelson Jeanrenaud
 * @author Luca Coduri
 * @author Chloé Fontaine
 *
 * @version 1.0
 * Keyboard bindings :
 *      e -> clear the screen
 *      b -> generate hollow shapes
 *      f -> generate filled shapes
 *      q -> quit the application
 */
public class Bouncers implements Runnable{
    /**
     * time between updates of the shape positions (ms)
     */
    private final int UPDATE_RATE = 1000 / 60; // 60 Updates per seconds

    private final int NB_SQUARES_GENERATION = 10;
    private final int NB_CIRCLES_GENERATION = 10;

    /**
     * List of all the bouncable objects that are drawn onto the canvas
     */
    private List<Bouncable> bouncablesToDisplay;
    /**
     * Factory to create the hollow bouncable objects
     */
    private HollowShapeFactory hollowFactory;
    /**
     * Factory to create the fille dbouncable objects
     */
    private FilledShapeFactory filledFactory;

    /**
     * Run the main application
     */
    public void run(){
        bouncablesToDisplay = new ArrayList<Bouncable>();
        hollowFactory = HollowShapeFactory.getInstance();
        filledFactory = FilledShapeFactory.getInstance();
        MainWindow mainwindow = MainWindow.getInstance();

        mainwindow.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyChar()) {
                        case 'e' -> bouncablesToDisplay.clear();
                        case 'b' -> generateShape(NB_CIRCLES_GENERATION, NB_SQUARES_GENERATION, hollowFactory);
                        case 'f' -> generateShape(NB_CIRCLES_GENERATION, NB_SQUARES_GENERATION, filledFactory);
                        case 'q' -> System.exit(0);
                        default -> {
                        }
                    }
                }
        });

        Timer t = new Timer(UPDATE_RATE, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                for (Bouncable bounce: bouncablesToDisplay) {
                    bounce.move();
                    bounce.draw();
                }
                mainwindow.repaint();

            }
        });
        t.setRepeats(true);
        t.start();
    }

    /**
     * Generate a set number of circles and squares using a particular factory
     *
     * @param nbCircles the number of circles to generate
     * @param nbSquares the number of squares to generate
     * @param factory factory used to generate the shapes
     */
    private void generateShape(int nbCircles, int nbSquares, BouncableFactory factory){
        for (int i = 0; i < nbCircles; i++) {
            bouncablesToDisplay.add(factory.createCircle(MainWindow.getInstance()));
        }
        for (int i = 0; i < nbSquares; i++) {
            bouncablesToDisplay.add(factory.createSquare(MainWindow.getInstance()));
        }
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Bouncers());
    }
}
