/*
Interfejs reprezentuj�cy dowoln� figur� geometryczn�, okre�laj�cy cechy ka�dej
figury - pole powierzchi i przynale�no�� punktu.
*/

package geometry;

public interface Shape {
  long area ();
  boolean contains (Point p);
}

