package com.problem;

import java.util.Scanner;

/**
 * Created by Евгений on 05.03.2017.
 */



public class Main {
    public static void main(String[] args) {
     /*   Scanner sc = new Scanner(System.in);

System.out.println("Ввежите количество точек");
        int n = sc.nextInt(); // количество вершин
        double min = -1; // квадрат минимальной площади
        MySet answer_triangle = new MySet(); // треугольник минимальной площади
        Point[] points = new Point[n]; // массив всех точек
        System.out.println("Ввежите координаты точек точек в виде '1 X Y' через Enter");
        for (int i = 0; i < n; i++) {
            boolean flag = (sc.nextInt() == 1); // считываем число 1  - с консоли, 0 - рандомное заполние.

            if(flag) {

                int x = sc.nextInt(),y = sc.nextInt(); // считываем координаты точки
                points[i] = new Point(x,y); // добавляем в массив
            } else {
                points[i] = new Point(); // заполняем рандомными координатами и добавляем в массив
            }
        }

        for (int i = 0; i < n; i++) {  // переберем первую вершину треугольника
            for (int j = 0; j < n; j++) {  // переберем вторую вершину треугольника
                for (int h = 0; h < n; h++) {  // переберем третью вершину треугольника
                    if (i == j || i == h || j == h) continue; // проверим, что мы выбрали три различные точки

                    MySet triangle = new MySet(3, points[i], points[j], points[h]); // создадим треугольник с данными тремя вершинами
                    double square = triangle.Square(); // найдем квадрат его площади
                    if (square > 0 && (min == -1 || min > square)) { // если треугольник не вырожденный(площадь больше нуля) и его площадь меньше, чем та что была
                        min = square;                              // обновим значение минимальной площади
                        answer_triangle = triangle.myCopy();       // и треугольник минимальной площади
                    }
                }
            }
        }

        double minshort = Math.sqrt(min);
        System.out.print("Площадь наименьшего треугольника равна ");
        System.out.printf("%4.1f", minshort);*/
    }
}
