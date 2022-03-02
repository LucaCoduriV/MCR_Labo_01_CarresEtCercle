package engine;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static MainWindow instance;
    private Canvas canvas;

    private MainWindow() {
        canvas = new Canvas();

        getContentPane().setBackground(Color.WHITE);
        add(canvas);
        setSize(500, 500);
        setVisible(true);

        canvas.startUpdate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static MainWindow getInstance() {
        if (instance == null) {
            instance = new MainWindow();
        }

        return instance;
    }
}
