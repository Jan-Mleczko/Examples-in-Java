/*
Grupa figur geometrycznych umo¿liwiaj¹ca sprawdzanie przynale¿noœci punktu do
ca³ej grupy. Zastosowanie wbudowanej klasy Vector.
*/

package geometry;

import java.util.Vector;

public class ShapeGroup {
  private Vector<Shape> members;

  public ShapeGroup () {
    members = new Vector<Shape> ();
  }

  public void addShape (Shape s) {
    members.add (s);
  }

  public boolean contains (Point p) {
    int i, nMembers;

    nMembers = members.size ();
    for (i = 0; i < nMembers; ++i) {
      if (members.get (i).contains (p))
        return true;
    }
    return false;
  }
}

