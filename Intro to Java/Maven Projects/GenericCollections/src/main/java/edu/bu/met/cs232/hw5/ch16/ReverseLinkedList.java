package edu.bu.met.cs232.hw5.ch16;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * ReverseLinkedList
 * 16.18
 * Created by jmkoni on 3/31/16.
 *
 * This application takes in a linkedList (I decided to use integers, but it's not hard
 * to change to another variable type) and reverses it. In the matching "App" class, I
 * print out an example.
 *
 * To reverse the list, I cloned the old list, then went through each node, copying the
 * int value into the new list and then removing it from the old.
 */
public class ReverseLinkedList {
  private LinkedList<Integer> originalList;
  private LinkedList<Integer> reversedList;

  public ReverseLinkedList(){
    this.originalList = new LinkedList(Arrays.asList(1,2,3,4,5));
    this.reversedList = reversedList(this.originalList);
  }

  public ReverseLinkedList(LinkedList list){
    this.originalList = list;
    this.reversedList = reversedList(list);
  }

  public LinkedList getOriginalList(){
    return this.originalList;
  }

  public LinkedList getReversedList(){
    return this.reversedList;
  }

  public LinkedList reversedList(LinkedList<Integer> list){
    LinkedList<Integer> oldList = new LinkedList();
    oldList = (LinkedList) list.clone();
    LinkedList<Integer> newList = new LinkedList<Integer>();
    while(oldList.size() > 0){
      newList.addLast(oldList.getLast());
      oldList.removeLast();
    }
    return newList;
  }
}
