package graphics;

import javax.swing.*;
import java.awt.*;

public class MainWindow implements Displayer {
    private static MainWindow instance;
    private Canvas canvas;
    private JFrame frame;
    private MainWindow() {
        canvas = new Canvas();
        frame = new JFrame();

        frame.getContentPane().setBackground(Color.WHITE);
        frame.add(canvas);
        frame.setSize(500, 500);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static MainWindow getInstance() {
        if (instance == null) {
            instance = new MainWindow();
        }

        return instance;
    }

    @Override
    public int getWidth() {
        return frame.getWidth();
    }

    @Override
    public int getHeight() {
        return frame.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) frame.getGraphics();
    }

    @Override
    public void repaint() {
        frame.repaint();
        //canvas.repaint();
    }

    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }
}
