/*
Model geometryczny jako klasyczny przyk�ad zastosowania OOP. Klasa
reprezentuje punkty na p�aszczy�nie, mi�dzy kt�rymi mo�na oblicza� odleg�o��,
oraz je por�wnywa� (z priorytetem wsp�rz�dnej Y) - przyk�ad implementacji
interfejsu wbudowanego Comparable.
*/

package geometry;

public class Point
implements Comparable<Point> {
  private int x, y;
  public static final Point ZERO = new Point ();

  private Point () {
    this (0, 0);
  }

  public Point (int initX, int initY) {
    x = initX;
    y = initY;
  }

  public int getX () {
    return x;
  }

  public int getY () {
    return y;
  }

  private static int square (int a) {
    return a * a;
  }

  public int distance (Point p) {
    int xDist, yDist;

    xDist = x - p.getX ();
    yDist = y - p.getY ();
    return (int) Math.sqrt (square (xDist) + square (yDist));
  }

  public int compareTo (Point p) {
    int py = p.getY ();

    if (y < py) {
      return -1;
    }
    if (y > py) {
      return +1;
    }
    return x - p.getX ();
  }

  public boolean equals (Point p) {
    return compareTo (p) == 0;
  }

  public String toString () {
    return x + "," + y;
  }
}

