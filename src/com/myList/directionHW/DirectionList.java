package com.myList.directionHW;

//goal: 双向链表(done)，且头尾相连形成闭环(to do)。这样left，right永远可以找到对应的方向
//闭环之后怎么得到size()??--给个int size，每次加都记录size + 1；
public class DirectionList {
  public Direction first;
  public Direction head;
  private int size;

//  private void resetHead() {
//    if (head !=null) {
//      while (head.right != null) {
//        head = head.right;
//      }
//    }
//  }

  public DirectionList(String d) {
    first = new Direction(null, d, null);
    head = first;
    size = 1;
  }

  public void add(String x) {
    head.right = new Direction(head, x, null);
    head = head.right;
    closeCircle();
    size++;
  }

  private void closeCircle() {
    head.right = first;
  }

  public Direction get(int x) {
    Direction result = head;
    for (int i = size() - 1 ; i > x; i--) {
      result = result.left;
    }
    return result;
  }

  public int size() {
    return size;
  }

  //原来的size(), 在linear list中，遍历list得到size；这个方法有一个缺点就是list特别大的时候需要遍历很久；同时是circular list的时候也没有exit condition
//  public int size() {
//    int totalsize = 1;
//    while (head.left != null) {
//        totalsize++;
//        head = head.left;
//      }
//    resetHead();
//    return totalsize;
//  }

  public static void main(String[] args) {
    DirectionList dl = new DirectionList("E");
    dl.add("S");
    dl.add("W");
    dl.add("N");
    System.out.println(dl.size());
    Direction one = dl.get(3);
    System.out.println(one.getDirection() + "的left是: " + one.left.getDirection()
                      + "; right是: " + one.right.getDirection());
  }
}
