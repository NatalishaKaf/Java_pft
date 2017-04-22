package ru.dis.points;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
 public void testDistance (){
    Point p1= new Point(0, 5);
    Point p2= new Point(15, 7);
    Assert.assertEquals(p1.distance(p2), 15.132745950421556);
     }
 }