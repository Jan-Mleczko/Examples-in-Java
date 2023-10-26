/*
Drzewo binarne (zwane BST) z dodawaniem i wyszukiwaniem elementów - liczb.
Przyk³ad zastosowania typów uogólnionych.

Binary tree with element insertion and search. Generic type use example.
*/

class BSTree<E extends Comparable<E>> {
  private BSTree<E> left, right;
  private E value;
  private int occur;
  private boolean empty;

  public BSTree () {
    empty = true;
  }

  private void assignValue (E val) {
    empty = false;
    value = val;
    occur = 1;
    left = right = null;
  }

  private BSTree (E val) {
    assignValue (val);
  }

  int compareToMe (E val) {
    return val.compareTo (value);
  }

  /* Dodanie elementu. */
  public void insert (E val) {
    if (empty)
      assignValue (val);
    else {
      int comp = compareToMe (val);

      if (comp == 0)
        ++occur;
      else
        if (comp < 0)
          if (left == null)
            left = new BSTree<E> (val);
          else
            left.insert (val);
        else
          if (right == null)
            right = new BSTree<E> (val);
          else
            right.insert (val);
    }
  }

  /* Wyszukanie elementu, tj. okreœlenie iloœci wyst¹pieñ. */
  public int search (E val) {
    if (empty)
      return 0;

    int comp = compareToMe (val);
    if (comp == 0)
      return occur;

    BSTree<E> scope = (comp < 0) ? left : right;
    return (scope == null) ? 0 : scope.search (val);
  }
}
