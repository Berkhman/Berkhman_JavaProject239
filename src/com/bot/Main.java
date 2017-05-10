package com.bot;

import com.problem.MySet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by Евгений Берхман.
 */
public class Main {
    private static ArrayList<Point> points = new ArrayList<Point>();
    private static ArrayList<Point> ansPoints = new ArrayList<Point>();

    public static void createGUI() {
        final JFrame frame = new JFrame("Berkhman__project");
        frame.setPreferredSize(new Dimension(700, 700));
        JPanel panel = new JPanel(new BorderLayout());
        final Panel butPanel = new Panel();
        butPanel.setLayout(null);
        butPanel.setPreferredSize(new Dimension(250, 700));
        final Panel pointpane = new Panel();
        pointpane.setLayout(null);
        //pointpane.setPreferredSize(new Dimension(350,700));

        JLabel addPointwithCoords = new JLabel("Добавить точку по координатам");
        addPointwithCoords.setBounds(2, 2, 300, 25);
        butPanel.add(addPointwithCoords);
        JLabel addRandomPoints = new JLabel("Добавить рандомное количество точек");
        addRandomPoints.setBounds(2, 50, 300, 25);
        butPanel.add(addRandomPoints);
        JLabel X = new JLabel("X:");
        X.setBounds(2, 25, 15, 25);
        butPanel.add(X);
        JLabel Y = new JLabel("Y:");
        Y.setBounds(45, 25, 15, 25);
        butPanel.add(Y);
        JLabel N = new JLabel("NUM:");
        N.setBounds(2, 70, 30, 25);
        butPanel.add(N);
        final JTextField x = new JTextField();
        x.setBounds(17, 25, 25, 25);
        butPanel.add(x);//поля для введения координат точки вручную с клавиатуры
        final JTextField y = new JTextField();
        y.setBounds(60, 25, 25, 25);
        butPanel.add(y);//поля для введения координат точки вручную с клавиатуры
        final JTextField n = new JTextField();
        n.setBounds(35, 70, 25, 25);
        butPanel.add(n);//поля для введения количества рандомных точек с клавыиатуры
        final JLabel otv = new JLabel("Ответ:");
        otv.setBounds(20, 350, 50, 25);
        butPanel.add(otv);
        final JLabel pics = new JLabel("пикс^2");
        pics.setBounds(120, 350, 50, 25);
        butPanel.add(pics);
        final JLabel dva = new JLabel("Данную кнопку ");
        dva.setBounds(163, 280, 200, 40);
        butPanel.add(dva);
        final JLabel dvaa = new JLabel("следует нажи-");
        dvaa.setBounds(165, 300, 200, 40);
        butPanel.add(dvaa);
        final JLabel dvaaa = new JLabel("мать дважды");
        dvaaa.setBounds(165, 320, 200, 40);
        butPanel.add(dvaaa);
        // final JLabel sm = new JLabel("см^2");
        // sm.setBounds(120, 373, 50, 25);
        // butPanel.add(sm);


        JButton button1 = new JButton("Добавить точку");
        button1.setBounds(2, 100, 160, 40);
        butPanel.add(button1);//создадим кнопкку добавления точек
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int X = (!x.getText().equals("") ? Integer.parseInt(x.getText()) : 0);
                int Y = (!y.getText().equals("") ? Integer.parseInt(y.getText()) : 0);
                int N = (!n.getText().equals("") ? Integer.parseInt(n.getText()) : 0);//убедимся что поля ввода не пустые
                if ((X > 0) && (Y > 0)) {
                    Point b = new Point(X, Y);
                    points.add(b);
                    b.setBounds(b.x, b.y, b.x + 4, b.y + 4);
                    pointpane.add(b);
                    pointpane.revalidate();
                    pointpane.repaint();//создадим точки по заданным координатам
                } else {
                    if (N > 0) {
                        for (int i = 0; i < N; i++) {
                            Point b = new Point((int) (Math.random() * (frame.getWidth() - 250)), (int) (Math.random() * frame.getHeight()));
                            points.add(b);
                            b.setBounds(b.x, b.y, b.x + 4, b.y + 4);
                            pointpane.add(b);
                            pointpane.revalidate();
                            pointpane.repaint();//создадим точки по количеству рандомных
                        }
                    }
                }

            }
        });
        JButton button3 = new JButton("Выполнить код");
        button3.setBounds(2, 300, 160, 40);
        butPanel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double min = -1; // квадрат минимальной площади
                MySet answer_triangle = new MySet(); //создадим треугольник минимальной площади
                Point[] points2 = new Point[points.size()];
                int n = points.size();
                for (int i = 0; i < n; i++) {
                    points2[i] = points.get(i);
                }

                /*for (int i = 0; i < points.size(); i++) {
                    while (points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);
                        pointpane.repaint();
                        pointpane.revalidate();
                    }
                }//стир то*/

                for (int i = 0; i < n; i++) {  // переберем первую вершину треугольника
                    for (int j = 0; j < n; j++) {  // переберем вторую вершину треугольника
                        for (int h = 0; h < n; h++) {  // переберем третью вершину треугольника
                            if (i == j || i == h || j == h) continue; // проверим, что мы выбрали три различные точки

                            MySet triangle = new MySet(3, points2[i], points2[j], points2[h]); // создадим треугольник с данными тремя вершинами
                            double square = triangle.Square(); // найдем квадрат его площади
                            if (square > 0 && (min == -1 || min > square)) { // если треугольник не вырожденный(площадь больше нуля) и его площадь меньше, чем та что была
                                min = square;                              // обновим значение минимальной площади
                                answer_triangle = triangle.myCopy();
                               /*HashSet<Point> hs = answer_triangle.getSet();
                                for (Point p : hs) {
                                points.add(p);
                                p.setBounds(p.x, p.y, p.x + 3, p.y + 3);
                                pointpane.add(p);}
                                pointpane.repaint();
                                pointpane.revalidate();*/
                                double minshort = min;
                                double minshort1 = Math.round(10000.0 * minshort) / 10000.0;
                                String aString = Double.toString(minshort1);
                                double minshort2 = min * 0.02636 * 0.02636;//переведем пиксели квт. в сантиметры квт.
                                double minshort3 = Math.rint(10000.0 * minshort2) / 10000.0;
                                String bString = Double.toString(minshort3);
                                final JTextField min1 = new JTextField();
                                min1.setBounds(70, 350, 50, 20);
                                min1.setText(aString);
                                butPanel.add(min1);//выведем значение мин площади в пикселях квт.
                                // final JTextField min2 = new JTextField();
                                // min2.setBounds(70, 373, 50, 20);
                                // min2.setText(bString);
                                // butPanel.add(min2);//выведем значение мин площади в сантиметрах квт.

                            }
                        }
                    }
                }

                for (int i = 0; i < points.size(); i++) {
                    while (points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);
                        pointpane.repaint();
                    }
                    pointpane.revalidate();
                }

                ansPoints.clear();//сначала тираем все точки


                for (Point i : answer_triangle.getSet()) {
                    ansPoints.add(i);
                    points.add(i);
                    pointpane.add(i);

                }
                pointpane.repaint();
            }
        });//добавляем каждую точку из искомого треугольника обратно

        JButton button5 = new JButton("Прочитать файл");
        button5.setBounds(2, 200, 160, 40);
        butPanel.add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Scanner in = new Scanner(new File("input.txt"))) {//в папке проекта должен лежать файл с таим именем
                    int n = in.nextInt(); //вводим количество точек
                    for (int i = 0; i < n; i++) {
                        points.add(new Point(in.nextInt(), in.nextInt()));//вводим сами точки и добавляем их в points
                    }
                    /* Пример водного файла
                    4
                    1 2
                    240 123
                    18 190
                    492 140
                     */
                } catch (Exception e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        });

        JButton button6 = new JButton("Записать в файл");
        button6.setBounds(2, 250, 160, 40);
        butPanel.add(button6);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (PrintWriter out = new PrintWriter(new File("output.txt"))) {//в папке проекта должен лежать файл с таким именем
                    for (Point i : ansPoints) {
                        out.println("(" + i.x + ";" + i.y + ")");
                    }

                } catch (Exception e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        });

        JButton button2 = new JButton("Очистить");//создадим кнопку для удаления всех точек
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < points.size(); i++) {
                    while (points.size() > 0) {
                        int index = points.size() - 1;
                        Point point = points.remove(index);
                        pointpane.remove(point);
                        pointpane.repaint();
                        pointpane.revalidate();//стираем все точки
                    }
                }
            }
        });

        button2.setBounds(2, 150, 160, 40);
        butPanel.add(button2);
        panel.add(pointpane, BorderLayout.CENTER);
        panel.add(butPanel, BorderLayout.EAST);
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
        //JTextArea Answersquare = new JTextArea();
    }
}