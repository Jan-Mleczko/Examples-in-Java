/*
Prostok¹t okreœlony przez 2 punkty. Wyliczanie pola prostok¹tów i ocena
przynale¿noœci punktu do prostok¹ta.
*/

package geometry;

public class Rectangle
implements Shape {
  private Point p1, p2;

  private Rectangle () {}

  private void initRectangle (int x1, int y1, int x2, int y2) {
    if (x1 > x2) {
      int temp;

      temp = x1;
      x1 = x2;
      x2 = temp;
    }
    if (y1 > y2) {
      int temp;

      temp = y1;
      y1 = y2;
      y2 = temp;
    }
    p1 = new Point (x1, y1);
    p2 = new Point (x2, y2);
  }

  public Rectangle (int x1, int y1, int x2, int y2) {
    initRectangle (x1, y1, x2, y2);
  }

  public Rectangle (Point initP1, Point initP2) {
    if (initP1.compareTo (initP2) < 0) {
      p1 = initP1;
      p2 = initP2;
    }
    else {
      initRectangle (p1.getX (), p1.getY (), p2.getX (), p2.getY ());
    }
  }

  public Point getP1 () {
    return p1;
  }

  public int getX1 () {
    return p1.getX ();
  }

  public int getY1 () {
    return p1.getY ();
  }

  public Point getP2 () {
    return p2;
  }

  public int getX2 () {
    return p2.getX ();
  }

  public int getY2 () {
    return p2.getY ();
  }

  public int getWidth () {
    return p2.getX () - p1.getX ();
  }

  public int getHeight () {
    return p2.getY () - p1.getY ();
  }

  public long area () {
    return getWidth () * getHeight ();
  }

  public boolean contains (Point p) {
    return p.compareTo (p1) >= 0 && p.compareTo (p2) <= 0;
  }
}

