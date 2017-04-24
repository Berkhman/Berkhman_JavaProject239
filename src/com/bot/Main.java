package com.bot;

import com.problem.MySet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    private static ArrayList<Point> points = new ArrayList<Point>();
    public static void createGUI() {
        final JFrame frame = new JFrame("Testframe");
	    frame.setPreferredSize(new Dimension(700,700));
	    JPanel panel = new JPanel(new BorderLayout());
        final Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(250,700));
        final Panel pointpane   = new Panel();
        pointpane.setLayout(null);
        //pointpane.setPreferredSize(new Dimension(350,700));

	    JLabel addPointwithCoords = new JLabel("Добавить точку по координатам");
	    addPointwithCoords.setBounds(2,2,300,25);
	    butPanel.add(addPointwithCoords);
	    JLabel addRandomPoints = new JLabel("Добавить рандомное количество точек");
	    addRandomPoints.setBounds(2,50,300,25);
	    butPanel.add(addRandomPoints);
        JLabel X = new JLabel("X:");
        X.setBounds(2,25,15,25);
        butPanel.add(X);
        JLabel Y = new JLabel("Y:");
        Y.setBounds(45,25,15,25);
        butPanel.add(Y);
        JLabel N = new JLabel("NUM:");
        N.setBounds(2,70,30,25);
        butPanel.add(N);
        final JTextField x = new JTextField();
        x.setBounds(17,25, 25,25);
        butPanel.add(x);
        final JTextField y = new JTextField();
        y.setBounds(60,25, 25,25);
        butPanel.add(y);
        final JTextField n = new JTextField();
        n.setBounds(35,70,25,25);
        butPanel.add(n);
        JLabel otv = new JLabel("Ответ:");
        otv.setBounds(20,350,50,25);
        butPanel.add(otv);



        JButton button1 = new JButton("Добавить точку");
        button1.setBounds(2,100,160,40);
        butPanel.add(button1);
        button1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int X = (!x.getText().equals("")?Integer.parseInt(x.getText()):0);
                int Y= (!y.getText().equals("")?Integer.parseInt(y.getText()):0);
                int N = (!n.getText().equals("")?Integer.parseInt(n.getText()):0);
                if ((X>0) && (Y>0)) {
                    Point b =  new Point(X, Y);
                    points.add(b);
                    b.setBounds(b.x,b.y,b.x+3,b.y+3);
                    pointpane.add(b);
                    pointpane.revalidate();
                    pointpane.repaint();
                }
                else {
                    if (N>0){
                        for (int i=0;i<N;i++){
                            Point b = new Point((int)(Math.random()*(frame.getWidth()-250)), (int)(Math.random()*frame.getHeight()));
                            points.add(b);
                            b.setBounds(b.x,b.y,b.x+3,b.y+3);
                            pointpane.add(b);
                            pointpane.revalidate();
                            pointpane.repaint();
                        }
                    }
                }

            }
        });
        JButton button3 = new JButton("Выполнить код");
        button3.setBounds(2,300,160,40);
        butPanel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double min = -1; // квадрат минимальной площади
                MySet answer_triangle = new MySet(); // треугольник минимальной площади
                Point[] points2 = new Point[points.size()];
                int n = points.size();
                for (int i =0; i<n; i ++){
                    points2[i]=points.get(i);
                }

                for (int i=0;i<points.size();i++){
                    while(points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }

                for (int i = 0; i < n; i++) {  // переберем первую вершину треугольника
                    for (int j = 0; j < n; j++) {  // переберем вторую вершину треугольника
                        for (int h = 0; h < n; h++) {  // переберем третью вершину треугольника
                            if (i == j || i == h || j == h) continue; // проверим, что мы выбрали три различные точки

                            MySet triangle = new MySet(3, points2[i], points2[j], points2[h]); // создадим треугольник с данными тремя вершинами
                            double square = triangle.Square(); // найдем квадрат его площади
                            if (square > 0 && (min == -1 || min > square)) { // если треугольник не вырожденный(площадь больше нуля) и его площадь меньше, чем та что была
                                min = square;                              // обновим значение минимальной площади
                                answer_triangle = triangle.myCopy();
                                HashSet <Point> hs = answer_triangle.getSet();
                                for (Point p: hs){
                                    points.add(p);
                                    p.setBounds(p.x,p.y,p.x+3,p.y+3);
                                    pointpane.add(p);
                                    System.out.println(p);

                                }
                                pointpane.repaint();
                                pointpane.revalidate();

                                double minshort = Math.sqrt(min);
                                System.out.print( minshort);
                                double minshort1 = Math.round(minshort * 100) / 100;
                                String aString = Double.toString(minshort1);
                                final JTextField min1 = new JTextField("Ответ:");
                                min1.setBounds(70,350,50,20);
                                min1.setText(aString);
                                butPanel.add(min1);

                            }
                        }
                    }
                }


                //for (int i = 0; i < 3; i++) {
        //            points.add(answer_triangle.add[i]);
     //           }

                for (int i=0;i<points.size();i++){
                    while(points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }

             /*   for(int i = 0; i < 3; i++) {
                    points.add(answer_triangle.arr[i]);
                }*/
            }

        });

        JButton button2 = new JButton("очистить");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<points.size();i++){
                    while(points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }
            }
        });

        button2.setBounds(2,150,160,40);
        butPanel.add(button2);
        panel.add(pointpane,BorderLayout.CENTER);
        panel.add(butPanel,BorderLayout.EAST);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
        JTextArea Answersquare = new JTextArea();
}
}
