package com.myList.arrayBased;


/**
 * Here we'll build a DIY int type arrayList with max-size fixed to make things easier.
 * In AList2.java we'll improve it to make our AList more like the JAVA ArrayList with extendable size.
 * size is the AList size instead of the initial_capacity size(max-size);
 * Invariant: addLast() method always add element into the position = size;
 *            getLast() method always get the last element from the position = size - 1;
 */

public class AList1 {
  private static final int INITIAL_CAPACITY = 100;
  private int size;
  private int[] items;

  public AList1() {
    items = new int[INITIAL_CAPACITY];
    size = 0;
  }

  public int size() {
    return size;
  }
  public void addLast(int i) {
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
    return removedItem;
  }

  public static void main(String[] args) {
    AList1 aList = new AList1();
    aList.addLast(5);
    aList.addLast(7);
    aList.addLast(9);
    System.out.println(aList.getLast() + ", and the size is " + aList.size());
//    System.out.println(aList.get(4)); //exception
  }
}
