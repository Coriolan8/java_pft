package ru.stqa.pft.sandbox;

/**
 * Created by Yulia on 08.07.2018.
 */
public class Square {

  public double l;

  public Square(double l){
    this.l = l;
  }

  public double area() {
    return this.l * this.l;
  }
}
