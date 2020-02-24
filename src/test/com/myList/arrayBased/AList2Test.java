package com.myList.arrayBased;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AList2Test {
  private AList2 list;

  @Before
  public void init() {
    list = new AList2();
    list.addLast(2);
    list.addLast(3);
    list.addLast(5);
  }

  @Test
  public void size() {
    int size = list.size();
    assertEquals(3, size);
  }

  @Test
  public void getLast() {
    assertEquals(5, list.getLast());
  }

  @Test
  public void get() {
    assertEquals(3, list.get(1));
  }

  @Test
  public void removeLast() {
    list.removeLast();
    assertEquals(3, list.getLast());
  }
}