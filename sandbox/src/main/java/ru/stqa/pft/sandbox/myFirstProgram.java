package ru.stqa.pft.sandbox;

public class myFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("Yulia");
    hello("Dima");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со строной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со стронами " + r.a + " и " + r.b + " = " + r.area());

    Point p1 = new Point(0, 1);
    Point p2 = new Point(3, 5);
    System.out.println("Растояние между двумя точками в пространстве = " + distance(p1, p2));
    System.out.println("Растояние между двумя точками в пространстве = " + p1.distance(p2));

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double distance(Point p1, Point p2) {
    double a = (p2.x - p1.x) * (p2.x - p1.x);
    double b = (p2.y - p1.y) * (p2.y - p1.y);
    return Math.sqrt(a + b);
  }

}

