package edu.bu.met.cs232.hw5.ch16;

/**
 * Created by jmkoni on 3/31/16.
 */
public class ReverseLinkedListApp {
  public static void main(String[] args){
    ReverseLinkedList rll = new ReverseLinkedList();
    System.out.println("Here is the original list: ");
    System.out.println(rll.getOriginalList());
    System.out.println("And here is the reversed list: ");
    System.out.println(rll.getReversedList());
  }
}
