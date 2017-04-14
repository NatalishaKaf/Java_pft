package ru.stqa.pft.sanbox;

public class myFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello ("mommy!");
    hello("users");

    double l=5;
    System.out.println("Площадь квадрата со стороной " + l+ "=" + area(l) );

    double a= 8;
    double b= 6;
    System.out.println("Площадь прямоугольника " + "=" + area(a,b));
  }


    public static void hello(String somebody) {    //void выводит пустое значение. функция не возвращает значение (не имеет вычислений)

    System.out.println("Hello, " + somebody +"!");
    }

    public static double area (double len){   //назначаем вычисление и возвращение значения

    return len*len;
    }
    public static double area (double a, double b) {
    return a * b;
   }

  }






