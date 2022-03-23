package UI;

import com.sun.tools.javac.Main;
import utility.Singleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends Singleton implements Displayer, ComponentListener {

    /**
     * Image on which the content is drawn
     */
    private Image image;
    /**
     * Dimension of the drawable area
     */
    private Dimension imageDimensions;
    /**
     * Graphics used to draw
     */
    private Graphics2D graphics2D;

    private JFrame frame;
    private JPanel panel;

    public MainWindow() { // TODO faut mettre en package ou jsp mais la visitibilité est a chier
        frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(); // TODO recheck double buff
        frame.add(panel);
        frame.setVisible(true);

        image = panel.createImage(getWidth(), getHeight());
        imageDimensions = new Dimension(getWidth(), getHeight());

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
        panel.getGraphics().drawImage(image, 0, 0, imageDimensions.width, // TODO je crois que je suis un animal
                imageDimensions.height, null);
        graphics2D.setColor(Color.cyan);
        graphics2D.fillRect(0, 0, imageDimensions.width, imageDimensions.height);
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
