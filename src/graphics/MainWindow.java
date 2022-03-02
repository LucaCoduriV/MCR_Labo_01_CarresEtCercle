package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class MainWindow implements Displayer {
    private static MainWindow instance;
    private Canvas canvas;
    private JFrame frame;
    private Image image;
    private Graphics2D g;

    private MainWindow() {
        canvas = new Canvas();
        frame = new JFrame();

        frame.getContentPane().setBackground(Color.WHITE);
        frame.add(canvas);
        frame.setSize(500, 500);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        image = canvas.createImage(getWidth(), getHeight());
        g = (Graphics2D) image.getGraphics();
    }

    public static MainWindow getInstance() {
        if (instance == null) {
            instance = new MainWindow();
        }

        return instance;
    }

    @Override
    public int getWidth() {
        return canvas.getWidth();
    }

    @Override
    public int getHeight() {
        return canvas.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return g;
    }

    @Override
    public void repaint() {
        //frame.repaint();
        //canvas.repaint();

        canvas.getGraphics().drawImage(image, 0, 0, null);
        g.setColor(frame.getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }
}
