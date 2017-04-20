package ru.dis.points;


public class Point {
  double x;
  double y;
  //public static void main(String[] args) {
  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }
  public double distance(Point Point2) {
    return Math.sqrt((x - Point2.x)*(x - Point2.x) + (y - Point2.y)*(y - Point2.y));
  }
  }
