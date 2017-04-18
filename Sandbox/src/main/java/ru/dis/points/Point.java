package ru.dis.points;


public class Point {
  double x;
  double y;
  //public static void main(String[] args) {
  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }
  public double distance(Point Point1, Point Point2) {
    return Math.sqrt((Point1.x - Point2.x)*(Point1.x - Point2.x) + (Point1.y - Point2.y)*(Point1.y - Point2.y));
  }
  }


