package ru.stqa.pft.sanbox;

public class myFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello ("mommy!");
    hello("users");

    Square s= new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l+ " = " + s.area() );

    Rectangle r =new Rectangle(8,6);
    System.out.println("Площадь прямоугольника со сторонами " +r.a + " и " + r.b+ " = " + r.area());
  }


    public static void hello(String somebody) {    //void выводит пустое значение. функция не возвращает значение (не имеет вычислений)

    System.out.println("Hello, " + somebody +"!");
    }




  }






