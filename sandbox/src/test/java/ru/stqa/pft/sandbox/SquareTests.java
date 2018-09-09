package ru.stqa.pft.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Yulia on 09.07.2018.
 */
public class SquareTests{
  @Test
  public void testArea(){
    Square s = new Square(5);
    Assert.assertEquals(s.area(), 24.0);
  }
}