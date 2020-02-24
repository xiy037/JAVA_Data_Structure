package com.myList.directionHW;

/**
 * DirectionList is indeed a circular and double linked list, so it can go forward and backward by
 * having the left and right pointer in each Node.
 */
//goal: 双向链表(done)，且头尾相连形成闭环(to do)。这样left，right永远可以找到对应的方向
//闭环之后怎么得到size()??--给个int size，每次加都记录size + 1；
public class DirectionList {
  public Direction first;
  public Direction last;
  private int size;

  public DirectionList(String d) {
    first = new Direction(null, d, null);
    last = first;
    size = 1;
  }

  public void addLast(String x) {
    last.right = new Direction(last, x, null);
    last = last.right;
    closeCircle();
    size++;
  }

  private void closeCircle() {
    first.left = last;
    last.right = first;
  }

  public Direction get(int x) {
    Direction result = last;
    for (int i = size() - 1 ; i > x; i--) {
      result = result.left;
    }
    return result;
  }

  public int size() {
    return size;
  }


  public static void main(String[] args) {
    DirectionList dl = new DirectionList("E");
    dl.addLast("S");
    dl.addLast("W");
    dl.addLast("N");
    System.out.println(dl.size());
    Direction one = dl.get(0);
    System.out.println(one.getDirection() + "的left是: " + one.left.getDirection()
                      + "; right是: " + one.right.getDirection());
  }
}
