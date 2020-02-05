package com.myList;

//put IntNode as inner Class
public class SLList2 {

  private static class IntNode {
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


  public IntNode first;
  public IntNode last;

  public SLList2(int x) {
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
    SLList2 sL = new SLList2(6);
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

