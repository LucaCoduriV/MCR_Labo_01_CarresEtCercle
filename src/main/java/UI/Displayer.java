package UI;

import java.awt.*;
import java.awt.event.KeyAdapter;

public interface Displayer {
    /**
     * @return the width of the displayer
     */
    int getWidth();

    /**
     * @return the height of the displayer
     */
    int getHeight();

    /**
     * @return the graphics of the displayer
     */
    Graphics2D getGraphics();

    /**
     * Repaint the displayer
     */
    void repaint();

    /**
     * Set the title of the displayer
     */
    void setTitle(String s);

    /**
     * Add a key listener to the displayer
     */
    void addKeyListener(KeyAdapter ka);
}
