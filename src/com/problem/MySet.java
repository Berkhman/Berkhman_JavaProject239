package com.problem;

import com.bot.Point;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Евгений Берхман.
 */
public class MySet {
    int k;
    Point[] arr;

    public MySet() {
    }//конструктор

    public MySet(int k, Point a, Point b, Point c) {
        arr = new Point[3];
        this.k = k;
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
    }//создадим массив из трех точек

    public HashSet<Point> getSet() {
        HashSet<Point> set = new HashSet<>();
        set.add(arr[0]);
        set.add(arr[1]);
        set.add(arr[2]);
        return set;
    }//метод возвращающий точки

    public double Square() { // метод, возвращающий квадрат площади треульника
        double la, lb, lc, p;
        la = arr[0].distance(arr[1]); // вычисляем длинны сторон
        lb = arr[1].distance(arr[2]);
        lc = arr[2].distance(arr[0]);
        p = (la + lb + lc) / 2; // вычисляем полупериметр
        return Math.sqrt(p * (p - la) * (p - lb) * (p - lc)); // считаем квадрат площади по формуле Герона
    }

    public MySet myCopy() {
        return new MySet(k, arr[0], arr[1], arr[2]);
    }
}
