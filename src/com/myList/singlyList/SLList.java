package com.myList.singlyList;

/**
 * SLList means Singly linked list.
 * The problem for SLList here is, if you try to removeLast(), you have to iterate through the list to find the one Node before the last
 * Node, and then point the `last IntNode` to that one.
 * This will slow down the remove speed.
 * The problem can be solved by double linked list.
 */
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
