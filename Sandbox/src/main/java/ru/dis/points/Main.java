package ru.dis.points;


public class Main {
  public static void main(String[] args) {
    Point p1 = new Point(0,5);
    Point p2 = new Point(15,7);
    System.out.println("Расcтояние между двумя точками на плоскости= " + p1.distance(p2));
  }

}
