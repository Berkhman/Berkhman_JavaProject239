package com.bot;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Евгений Берхман.
 */
public class Point extends JPanel {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point a) {
        return Math.sqrt((a.x - x) * ((a.x - x)) + (a.y - y) * (a.y - y));
    }// метод возвращающий расстояние между нашей и другой данной точкой


    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 3, 3);
        g.setColor(Color.red);//настроим параметры рисуемых точек
    }
}
