import UI.MainWindow;
import game.Bouncable;
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

        bouncebales.add(filledFactory.createCircle());

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

    public static void main(String[] args) throws Exception {
        new Bouncers().run();
    }
}
