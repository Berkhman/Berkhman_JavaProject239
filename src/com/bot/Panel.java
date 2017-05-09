package com.bot;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Евгений Берхман.
 */
public class Panel extends JPanel {
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);//зададим параметры окна
    }
}
