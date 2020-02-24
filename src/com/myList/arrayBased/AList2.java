package com.myList.arrayBased;

/**
 * AList2 is more like a real ArrayList-- it will change the size of the underlying array corresponding to the actual size;
 * It will extend to new size by new another array and copy the old array into it;
 * It will shrink size when too much space are useless after removing most elements;
 */

public class AList2 {
  private static final int INITIAL_CAPACITY = 10;
  private static final int EXTEND_FACTOR = 2;
  private int size;
  private int[] items;

  public AList2() {
    items = new int[INITIAL_CAPACITY];
    size = 0;
  }

  public int size() {
    return size;
  }

  private void resize(int capacity) {
    int[] newArr = new int[capacity];
    System.arraycopy(items, 0, newArr, 0, size);
    items = newArr;
  }

  public void addLast(int i) {
    if (size == items.length) {
      resize(size * EXTEND_FACTOR);
    }
    items[size] = i;
    size++;
  }

  public int getLast() {
    return items[size - 1];
  }

  public int get(int i) {
    if (i < 0 || i >= size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return items[i];
  }

  public int removeLast() {
    int removedItem = getLast();
    size--;
    if (items.length > INITIAL_CAPACITY && ((float)size / items.length) < 0.25) {
      resize(Math.round((float)items.length / 2));
    }
    return removedItem;
  }

  public static void main(String[] args) {
    AList2 two = new AList2();
    for (int i = 0; i < 30; i++) {
      two.addLast(i);
    }
    System.out.println(two.size);

    for (int i = 0; i < 25; i++) {
      two.removeLast();
    }
    System.out.println(two.size);
  }
}
