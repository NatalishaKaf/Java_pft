package ru.stqa.pft.sanbox;

/**
 * Created by jonik on 15.04.2017.
 */
public class Square {

  public double l;

  public Square(double l) {
    this.l = l;
  }

  public double area() {   //назначаем вычисление и возвращение значения

    return this.l * this.l;
  }
}