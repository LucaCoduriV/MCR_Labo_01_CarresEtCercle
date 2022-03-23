import UI.MainWindow;
import game.Bouncable;
import game.BouncableFactory;
import game.FilledShapeFactory;
import game.HollowShapeFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        //bouncebales.add(filledFactory.createCircle());

        MainWindow mainwindow = MainWindow.getInstance();

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
