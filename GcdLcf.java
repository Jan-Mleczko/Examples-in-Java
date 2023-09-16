/*
Wyliczanie NWD dw�ch liczb algorytmem Euklidesa w wersji z dzieleniem, oraz
NWW przy u�yciu NWD. Wyj�tek, je�eli przekazane liczby nie s� naturalne.

GCD calculation for two numbers using the Euclidean algorithm's variation with
division. LCF calculation using GCD. An exception, if the input numbers aren't
natural.
*/

class GcdLcf {
  private static void checkNatural (int x) {
    if (x < 1)
      throw new IllegalArgumentException ("Natural number required.");
  }

  public static int gcd (int a, int b) {
    checkNatural (a);
    checkNatural (b);
    while (((a > b) ? (a %= b) : (b %= a)) != 0);
    return a | b;
  }

  public static int lcf (int a, int b) {
    return a / gcd (a, b) * b;
  }
}

