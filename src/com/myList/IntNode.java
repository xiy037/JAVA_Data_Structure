package com.myList;

public class IntNode {
  private int item;
  public IntNode next;

  public IntNode(int i, IntNode n) {
    item = i;
    next = n;
  }

  public int getItem() {
    return item;
  }
}
