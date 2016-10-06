public class SimpleIntList implements Cloneable {

  private static class Node {
    private int data;
    private Node link;

    public Node (int e, Node p) {
      data = e;
      link = p;
    }

    public int getData() { return data; }
    public Node getLink() { return link; }
    public void setData(int e) { data = e; }
    public void setLink(Node p) { link = p; }
  }

  private Node head;
  private Node tail;
  private int size;

  // no-args constructor
  public SimpleIntList(){ }

  // add a new node with e to the head
  public void addToHead(int e){
    head = new Node(e, head);
    if (tail == null)
      tail = head;
    size++;
  }

  // add a new node with e to the tail
  public void addToTail(int e){
    Node p = new Node(e, null);
    if (tail != null){
      tail.setLink(p);
    }
    else{
      head = p;
    }
    tail = p;
    size++;
  }

  // remove and return the first node from the list
  public Node removeFromHead(){
    if (head != null) {
      Node h = head;
      head = new Node(head.link.getData(), head.link.link);;
      size--;
      return h;
    } else {
      return null;
    }

  }

  // remove and return the last node from the list
  public Node removeFromTail(){
    if (tail != null) {
      Node t = tail;
      // find node prior to tail
      Node h = head;
      while (h.getLink() != t) {
        h = h.getLink();
      }
      tail = h;
      h.setLink(null);
      size--;
      return t;
    } else {
      return null;
    }
  }

  // add a new node with e after the node p
  public void addAfter(Node p, int e){
    if (p != null) {
      Node r = p.getLink();
      Node q = new Node(e, r);
      p.setLink(q);
      if (tail == p) {
        tail = q;
      }
      size++;
    } else {
      addToTail(e);
    }
  }

  /**
   * This method adds a new node with element e before the node pointed to by p
   *
   * @param p
   *   Node object that the user wants to put the new value in front of
   * @param e
   *   Value that the user is trying to add to the list
   *
   * @postcondition
   *   The SimpleIntList is increased in size by one node and that node is added prior to given node.
   */
  public void addBefore(Node p, int e){
    if (p != null) {
      Node h = head;
      while (h.getLink() != p) {
        h = h.getLink();
      }
      Node i = new Node(e, p);
      h.setLink(i);
      size++;
    } else {
      addToHead(e);
    }
  }

  /**
   * The method searches the list for the first occurrence of the node with element e
   * and returns the pointer to the node.
   *
   * @param p
   *  Node object to start the search from
   * @param e
   *  Value that the user is trying to find
   *
   * @return
   *  The first node after p that equals the value of e. Null if value doesn’t exist in
   *  list.
   */
  public Node findNode(Node p, int e){
    if (p == null){
      p = head;
    }
    while ((p.getData() != e) && (p != tail)){
      p = p.getLink();
    }
    if (p.getData() != e){
      return null;
    } else {
      return p;
    }
  }

  /**
   * The method finds the n-th occurrence of the node with element e and returns the
   * pointer to the node.
   *
   * @param e
   *  Value that the user is trying to find
   * @param n
   *  Which occurrence of said value the user wants to find
   *
   * @return
   *  The n-th node in the list that contains the value e. Null if not found.
   */
  public Node findNodePos(int e, int n){
    if (head == null){
      return null;
    }

    int i = 0;
    Node h = head;

    while (h != tail) {
      if (h.getData() == e){ i++; }
      if ( (i == n) && (h.getData() == e) ){
        return h;
      }
      h = h.getLink();
    }
    return null;
  }

  /**
   * This method creates a separate copy of a list.
   *
   * @return
   *  A SimpleIntList object that is contains identical values, in the same order, as
   *  the cloned list
   *
   * @postcondition
   *  Cloned list should not link to original list and any changes to the cloned list
   *  should not occur on the original list
   */
  public SimpleIntList clone(){
    SimpleIntList cloneList = new SimpleIntList();
    if (head == null){ return cloneList; }
    Node h = head;
    cloneList.addToTail(h.getData());
    while (h != tail){
      h = h.getLink();
      cloneList.addToTail(h.getData());

    }
    return cloneList;
  }

  // print the size of the list and all elements in the list separated by spaces
  public void printList(){
    System.out.print("\nSize = " + size + ", List is: ");
    if (head != null){
      Node current = head;
      while (current != null){
        System.out.print(current.getData() + " ");
        current = current.getLink();
      }
    }
    else {
      System.out.print("The list is empty");
    }
  }

  // main method to test SimpleIntList
  public static void main(String[] args) {

    SimpleIntList myList = new SimpleIntList();
    myList.printList();
    myList.removeFromHead();
    myList.printList();
    myList.removeFromTail();
    myList.printList();
    SimpleIntList cloneList1 = myList.clone();
    cloneList1.printList();
    System.out.println();
    System.out.println("Expecting null: " + myList.findNodePos(60,2));
    myList.addAfter(myList.head, 70);
    myList.printList();
    myList.addToHead(60);
    myList.printList();
    myList.addToHead(40);
    myList.printList();
    myList.addToHead(20);
    myList.printList();
    myList.addToTail(80);
    myList.printList();
    myList.addToTail(100);
    myList.printList();
    myList.addToTail(120);
    myList.printList();
    myList.removeFromHead();
    myList.printList();
    myList.removeFromTail();
    myList.printList();
    myList.addAfter(myList.head.getLink(), 50);
    myList.printList();
    myList.addAfter(myList.tail, 130);
    myList.printList();
    myList.removeFromTail();
    myList.printList();
    myList.addBefore(myList.tail, 90);
    myList.printList();
    System.out.println();
    System.out.println("Expecting 80: " + myList.findNode(myList.head.getLink(),
        80).getData());
    System.out.println("Expecting 90 (null node to start): " + myList.findNode
        (null, 90).getData());
    System.out.println("Expecting null (value not in list): " + myList
        .findNode(myList.head, 10));
    System.out.println("Expecting 60: " + myList.findNodePos(60,1).getData());
    System.out.print("Expecting null: " + myList.findNodePos(60,2));
    myList.addAfter(myList.head, 80);
    myList.addBefore(myList.tail, 80);
    myList.printList();
    System.out.println();
    System.out.print("Expecting 80: " + myList.findNodePos(80,
        3).getData());
    SimpleIntList cloneList = myList.clone();
    cloneList.printList();
    cloneList.addAfter(cloneList.head.getLink(), 50);
    cloneList.printList();
    System.out.println();
    System.out.print("Shouldn't change myList...");
    myList.printList();

  }
}
