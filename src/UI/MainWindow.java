package UI;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow implements Displayer, ComponentListener {

    private static MainWindow instance;

    public static MainWindow getInstance() {
        if(instance == null){
            instance = new MainWindow();
        }
        return instance;
    }

    /**
     * Image on which the content is drawn
     */
    private Image image;

    /**
     * Graphics used to draw
     */
    private Graphics2D graphics2D;

    private JFrame frame;
    private JPanel panel;

    private MainWindow() {
        frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);

        panel = new JPanel(); // TODO recheck double buff
        frame.add(panel);
        frame.setVisible(true);

        image = panel.createImage(getWidth(), getHeight());

        graphics2D = (Graphics2D) image.getGraphics();

        frame.addComponentListener(this);
    }

    /**
     * @return Width of the drawwable area
     */
    @Override
    public int getWidth() {
        return panel.getWidth();
    }

    /**
     * @return Height of the drawwable area
     */
    @Override
    public int getHeight() {
        return panel.getHeight();
    }

    /**
     * @return Graphics drawn onto the window
     */
    @Override
    public Graphics2D getGraphics() {
        return graphics2D;
    }

    /**
     * Repaint the window and all components contained inside it.
     */
    @Override
    public void repaint() {
        panel.getGraphics().drawImage(image, 0, 0, null);
        graphics2D.setColor(frame.getBackground());
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
    }

    /**
     * Change the title of the window
     * @param title New title of the window
     */
    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }

    @Override
    public void keyListener(KeyAdapter ka) {

    }
    public void componentResized(ComponentEvent e) {
        image = panel.createImage(getWidth(), getHeight());
        graphics2D = (Graphics2D) image.getGraphics();
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
