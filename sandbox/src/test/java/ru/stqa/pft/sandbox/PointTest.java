package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Yulia on 10.07.2018.
 */
public class PointTest {

  @Test
  public void testDistance() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 5);
    Assert.assertEquals(5.0, p1.distance(p2));

    Point p3 = new Point(5, 0);
    Point p4 = new Point(-5, 0);
    Assert.assertEquals(10.0, p3.distance(p4));

    Point p5 = new Point(0, 1);
    Point p6 = new Point(3, 5);
    Assert.assertEquals(5.0, p5.distance(p6));

  }

}

