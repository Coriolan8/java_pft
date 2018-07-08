package ru.stqa.pft.sandbox;

/**
 * Created by Yulia on 08.07.2018.
 */
public class Point {
  public double x;
  public double y;


  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p1) {
    double a = (this.x - p1.x) * (this.x - p1.x);
    double b = (this.y - p1.y) * (this.y - p1.y);
    return Math.sqrt(a + b);
  }
}
