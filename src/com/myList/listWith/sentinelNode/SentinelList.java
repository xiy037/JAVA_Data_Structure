package com.myList.listWith.sentinelNode;

/**
 * sentinel node is introduced to handle special cases: i.e. empty list, when you still want addLast() method to work.
 * Because if you simply let first node points to null, the first.next cannot be found.
 * so sentinel node is pointed to Node(null, null) to always let sentinel.next available.
 */

public class SentinelList<T> {

  private class Node {
    T item;
    Node next;

    public Node(T i, Node n) {
      item = i;
      next = n;
    }
  }

  private Node sentinel;
  private int size;

  public SentinelList() {
    sentinel = new Node(null, null);
    size = 0;
  }

  public SentinelList(T x) {
    sentinel = new Node(null, null);
    sentinel.next = new Node(x, null);
    size = 1;
  }

  public void addFirst(T y) {
    sentinel.next = new Node(y, sentinel.next);
    size++;
  }

  public T getFirst() {
    return sentinel.next.item;
  }

  public void addLast(T y) {
    Node p = sentinel;
     while(p.next != null) {
       p = p.next;
     }
     size++;
    p.next = new Node(y, null);
  }

  public T getLast() {
    Node p = sentinel;
    while(p.next != null) {
      p = p.next;
    }
   return p.item;
  }

  public int size() {
    return size;
  }


  public static void main(String[] args) {
    SentinelList<String> nameList = new SentinelList<>("AlexOne");
    nameList.addFirst("AlexTwo");
    nameList.addFirst("AlexThree");
    System.out.println(nameList.getFirst());
    nameList.addLast("JohnOne");
    System.out.println(nameList.getLast());
    System.out.println(nameList.size());

    SentinelList<Integer> list = new SentinelList<>();
    list.addLast(22);
    System.out.println(list.getLast());
  }
}
