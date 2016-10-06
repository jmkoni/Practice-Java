package edu.bu.met.cs232.hw5.ch16;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * ReverseLinkedListTest
 * Created by jmkoni on 4/5/16.
 *
 * This tests the ReverseLinkedList application.
 */
public class ReverseLinkedListTest {
  private ReverseLinkedList rll;

  @Before
  public void setUp() throws Exception {
    rll = new ReverseLinkedList();
  }

  @After
  public void tearDown() throws Exception {
    rll = null;
  }

  @Test
  public void testGetOriginalList() throws Exception {
    LinkedList expectedOutput = new LinkedList(Arrays.asList(1,2,3,4,5));
    assertThat(expectedOutput, is(rll.getOriginalList()));
  }

  @Test
  public void testGetReversedList() throws Exception {
    LinkedList expectedOutput = new LinkedList(Arrays.asList(5,4,3,2,1));
    assertThat(expectedOutput, is(rll.getReversedList()));
  }

  @Test
  public void testReversedList() throws Exception {
    LinkedList expectedOutput = new LinkedList(Arrays.asList(8,2,10,3,5));
    assertThat(expectedOutput, is(rll.reversedList(new LinkedList(Arrays.asList(5,3,10,
        2,8)))));
  }
}