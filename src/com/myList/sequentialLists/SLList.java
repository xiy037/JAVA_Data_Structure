package com.myList.sequentialLists;

public class SLList {
  public IntNode first;
  public IntNode last;

  public SLList(int x) {
    first = new IntNode(x, null);
    last = first;
  }

  // add a to the front of the list
  public void addFirst(int a) {
    first = new IntNode(a, first);
  }

  public int getFirst() {
    return first.getItem();
  }

  //add a to the end of the list
  public void addLast(int a) {
      last.next = new IntNode(a, null);
      last = last.next;
  }

  public int getLast() {
      return last.getItem();
  }

  public static void main(String[] args) {
    SLList sL = new SLList(6);
    sL.addFirst(5);
    sL.addFirst(4);
    System.out.println(sL.getFirst());

    sL.addLast(7);
    sL.addLast(8);
    System.out.println(sL.getLast());

    sL.addFirst(3);
    System.out.println(sL.getFirst());
    System.out.println(sL.getLast());
  }
}
