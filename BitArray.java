/*
Tablica bitów spakowanych w bajty z odczytem i zapisem pojedynczych bitów.

Packed array of bits with individual bit read and write operations.
*/

class BitArray {
  private static class TranslatedIndex {
    public int indexPart, shiftPart;
  }

  private byte[] data;
  private int sizeBits, sizeBytes;
  private boolean mutable;

  private BitArray () {}

  private void fillZeroes () {
    int i;

    for (i = 0; i < sizeBytes; ++i)
      data[i] = 0;
  }

  public BitArray (int size) {
    if (size < 0)
      throw new NegativeArraySizeException ("BitArray with negative size.");
    sizeBits = size;
    sizeBytes = (size + 7) / 8;
    data = new byte[sizeBytes];
    mutable = true;
    fillZeroes ();
  }

  private void copyFrom (BitArray src) {
    int i;

    for (i = 0; i < sizeBytes; ++i)
      data[i] = src.data[i];
  }

  public BitArray (BitArray original) {
    sizeBits = original.sizeBits;
    sizeBytes = original.sizeBytes;
    data = new byte[sizeBytes];
    mutable = true;
    copyFrom (original);
  }

  public int size () {
    return sizeBits;
  }

  private TranslatedIndex translate (int flatIndex) {
    TranslatedIndex result = new TranslatedIndex ();
    if (flatIndex < 0)
      throw new IllegalArgumentException ("Negative index for BitArray.");
    if (flatIndex >= sizeBits)
      throw new IndexOutOfBoundsException ("BitArray index too high.");
    result.indexPart = flatIndex >> 3;
    result.shiftPart = flatIndex  & 7;
    return result;
  }

  public int readBit (int index) {
    TranslatedIndex ti = translate (index);
    return (data[ti.indexPart] >>> ti.shiftPart) & 1;
  }

  public boolean checkBit (int index) {
    return readBit (index) != 0;
  }

  public void writeBit (int index, int value) {
    if (mutable) {
      if (value != 0 && value != 1) {
        throw new IllegalArgumentException ("Only 0 & 1 bits for BitArray.");
      }

      TranslatedIndex ti = translate (index);
      int mask;

      mask = 1 << ti.shiftPart;
      if (value == 1)
        data[ti.indexPart] |= mask;
      else
        data[ti.indexPart] &= ~mask;
    }
    else
      throw new IllegalStateException ("It's an immutable BitArray.");
  }

  public void makeImmutable () {
    mutable = false;
  }

  public boolean isMutable () {
    return mutable;
  }
}

