package ru.dis.points;


public class Point {
  public static void main(String[] args){
    double x1=2;
    double x2= 5;
    double y1= 1;
    double y2= 7;
    double p1= x2-x1;
    double p2= y2-y1;

    System.out.println("Расстояние между двумя точками " + p1 + " и " + p2 + " на плоскости = " + distance(p1,p2));
  }

  public static double distance(double p1, double p2) {
    return Math.sqrt(p1*p1+p2*p2);
  }
}
