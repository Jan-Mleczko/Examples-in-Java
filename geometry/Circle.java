/*
Ko³o okreœlone przez punkt œrodka oraz promieñ z metodami obliczaj¹cymi pole
figury i oceniaj¹cymi przynale¿noœæ punktu do niej, zawartymi w interfejsie
Shape.
*/

package geometry;

public class Circle
implements Shape {
  private Point center;
  private int radius;

  private Circle () {}

  public Circle (Point c, int r) {
    if (r < 0) {
      throw new IllegalArgumentException ("Negative circle radius.");
    }
    center = c;
    radius = r;
  }

  public Circle (int cx, int cy, int r) {
    this (new Point (cx, cy), r);
  }

  public Point getCenter () {
    return center;
  }

  public int getCenterX () {
    return center.getX ();
  }

  public int getCenterY () {
    return center.getY ();
  }

  public int getRadius () {
    return radius;
  }

  public long area () {
    return (long) (radius * radius * Math.PI);
  }

  public boolean contains (Point p) {
    return p.distance (center) <= radius;
  }
}

