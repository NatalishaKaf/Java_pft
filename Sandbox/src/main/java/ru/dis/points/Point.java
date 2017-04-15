package ru.dis.points;


public class Point {
  public static void main(String[] args){
    DistanceBetweenPoints dbp= new DistanceBetweenPoints;
    double x1=2;
    double x2= 5;
    double y1= 1;
    double y2= 7;
    dbp.p1= x2-x1;
    dbp.p2= y2-y1;

    System.out.println("Расстояние между двумя точками " + dbp.p1 + " и " + dbp.p2 + " на плоскости = " + distance(dbp));
  }

  public static double distance(DistanceBetweenPoints dbp) {
    return Math.sqrt(dbp.p1* dbp.p1+dbp.p2* dbp.p2);
  }
}
