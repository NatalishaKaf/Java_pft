package ru.dis.points;

/**
 * Created by jonik on 18.04.2017.
 */
public class Main {
  public static void main(String[] args) {
    Point p1 = new Point(2,4);
    Point p2 = new Point(9,5);
    System.out.println("Расcтояние между двумя точками на плоскости= " + p1.distance(p1,p2));
  }

}
