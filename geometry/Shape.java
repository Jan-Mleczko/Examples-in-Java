/*
Interfejs reprezentuj¹cy dowoln¹ figurê geometryczn¹, okreœlaj¹cy cechy ka¿dej
figury - pole powierzchi i przynale¿noœæ punktu.
*/

package geometry;

public interface Shape {
  long area ();
  boolean contains (Point p);
}

