package ru.dis.points;


public class Point {
  public static void main(String[] args){
    DistanceBetweenPoints dbp= new DistanceBetweenPoints (2,5,1,7);

    System.out.println("Расстояние между двумя точками "+ "A("+ dbp.x1+ ";" + dbp.x2+ ")" + " и " + "B(" + dbp.y1+ ";" + dbp.y2 + ") " + "на плоскости = " + dbp.distance());
  }

}
