package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MainWindow implements Displayer, ComponentListener {
    private static MainWindow instance;
    private final JPanel canvas;
    private final JFrame frame;
    private Image image;
    private Graphics2D g;

    private MainWindow() {
        canvas = new JPanel();
        frame = new JFrame();

        frame.getContentPane().setBackground(Color.WHITE);
        frame.add(canvas);
        frame.setSize(500, 500);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        image = canvas.createImage(getWidth(), getHeight());
        g = (Graphics2D) image.getGraphics();

        frame.addComponentListener(this);
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
        canvas.getGraphics().drawImage(image, 0, 0, null);
        g.setColor(frame.getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        image = canvas.createImage(getWidth(), getHeight());
        g = (Graphics2D) image.getGraphics();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
