package com.myList.directionHW;

public class Direction {
  private String direction;
  public Direction left;
  public Direction right;

  public Direction(Direction l, String d, Direction r) {
    left = l;
    direction = d;
    right = r;
  }

  public String getDirection() {
    return direction;
  }

}
