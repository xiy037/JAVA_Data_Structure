package com.myList.sequentialLists;

import javax.naming.SizeLimitExceededException;

public class IntList {
  private int first;
  private IntList rest;

  //naked recursive data structure, weird!! will be improved later in SSList.java
  public IntList(int a, IntList b) {
    first = a;
    rest = b;
  }

  //copy constructor
  public IntList(IntList original) {
    first = original.first;
    if (original.rest == null) {
      rest = null;
    } else {
      rest = new IntList(original.rest);
    }
  }

  //get size using recursion
  public int size() {
    if (rest == null) {
      return 1;
    }
    return 1 + this.rest.size();
  }

  //get size without using recursion
  public int iterativeSize() {
    IntList p = this;
    int totalSize = 0;
    while (p != null) {
      totalSize += 1;
      p = p.rest;
    }
    return totalSize;
  }

  //no recursion to get item on index x;
  public int iterativeGet(int x) throws Exception {
    if (x < this.size()) {
      IntList p = this;
      for (int i = 0; i < x; i++) {
        p = p.rest;
      }
      return p.first;
    } else {
      throw new SizeLimitExceededException();
    }
  }

  //get item using recursion
  public int get(int x) {
    if (x == 0) {
      return first;
    }
    return rest.get(x - 1);
  }


  public static void main(String[] args) throws Exception {
    //very basic version：手动套娃版IntList；
    IntList L= new IntList(6, null);
    L = new IntList(4, L);
    L = new IntList(2, L);

    System.out.println(L.size());
    System.out.println(L.iterativeSize());
    System.out.println(L.iterativeGet(1));
    System.out.println(L.get(0));

    System.out.println("copy IntList L: ");
    IntList copyL = new IntList(L);
    int copyLen = copyL.size();
    for (int i = 0; i < copyLen; i++) {
      System.out.println(copyL.get(i));
    }
  }
}
