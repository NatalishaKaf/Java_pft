package ru.stqa.pft.sanbox;

/**
 * Created by jonik on 15.04.2017.
 */
public class Rectangle {
  public double a;
  public double b;
  public Rectangle (double a,double b){
    this.a=a;
    this.b=b;
  }
  public double area () {
    return this.a * this.b;
  }


}
