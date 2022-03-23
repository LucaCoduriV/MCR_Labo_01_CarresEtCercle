import UI.MainWindow;
import game.Bouncable;
import game.FilledShapeFactory;
import game.HollowShapeFactory;
import utility.Singleton;

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
        hollowFactory = (HollowShapeFactory) HollowShapeFactory.getInstance();
        filledFactory = (FilledShapeFactory) FilledShapeFactory.getInstance();

        bouncebales.add(hollowFactory.createCircle());

        MainWindow mainwindow = (MainWindow) MainWindow.getInstance();

        Timer t = new Timer(66, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                for (Bouncable bounce: bouncebales) {
                    bounce.draw();
                }
                mainwindow.repaint();
            }
        });
        t.setRepeats(true);
        t.start();
    }

    public static void main(String[] args) throws Exception {
        //MainWindow.register(MainWindow.class);
        //HollowShapeFactory.register(HollowShapeFactory.class);
        //FilledShapeFactory.register(FilledShapeFactory.class);
        new Bouncers().run();
    }
}
