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
import javax.swing.Timer;

public class Bouncers {
    List<Bouncable> bouncebales;
    HollowShapeFactory hollowFactory;
    FilledShapeFactory filledFactory;

    void run(){
        bouncebales = new ArrayList<Bouncable>();
        hollowFactory = HollowShapeFactory.getInstance();
        filledFactory = FilledShapeFactory.getInstance();

        generateShape(10, 10, filledFactory);

        MainWindow mainwindow = MainWindow.getInstance();

        mainwindow.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyChar()) {
                        case 'e' -> bouncebales.clear();
                        case 'b' -> generateShape(10, 10, hollowFactory);
                        case 'f' -> generateShape(10, 10, filledFactory);
                        case 'q' -> System.exit(0);
                        default -> {
                        }
                    }
                }
        });

        Timer t = new Timer(10, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                for (Bouncable bounce: bouncebales) {
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
            bouncebales.add(factory.createCircle());
        }
        for (int i = 0; i < nbSquares; i++) {
            bouncebales.add(factory.createSquare());
        }
    }

    public static void main(String[] args) throws Exception {
        new Bouncers().run();
    }
}
