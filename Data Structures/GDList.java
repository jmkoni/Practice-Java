import java.util.Scanner;
import java.io.*;

/**
 * GDList is a generic doubly linked list.
 * All elements are distinct
 **/
public class GDList<E> implements Cloneable
{
    /** inner class
     * GNode is a generic class representing a node in a list
     * E is generic type parameter of data
     * Has both previous and next pointers
     **/
    private static class GNode<E> {
        private E data;
        private GNode<E> previous;
        private GNode<E> next;

        // constructor
        public GNode (E e) {
            data = e;
            previous = null;
            next = null;
        }

        public E getData() { return data; }
        public GNode getPrevious() { return previous; }
        public GNode getNext() { return next; }
        public void setData(E e) { data = e; }
        public void setPrevious(GNode p) { previous = p; }
        public void setNext(GNode p) { next = p; }
    }

    private GNode<E> head;
    private GNode<E> tail;
    private int size;       // number of nodes in a list

    /** no-arg constructor creates an empty list
     **/

    public GDList( )
    {
        head = null;
        tail = null;
        size = 0;
    }

    /** add a new node with data e to the head
     * if a node with e already exists, return 1
     * if successful, return 0
     * increment the size
     **/
    public int addToHead(E e){
        GNode temp = new GNode(e);
        if (head == null){
            head = temp;
            tail = temp;
        }
        else{
            if (findNode(head, e) == null) {
                temp.setNext(head);
                head.setPrevious(temp);
                head = temp;
            }
            else return 1;
        }
        size++;
        return 0;
    }

    /** add a new node with data e to the tail
     * if a node with e already exists, return 1
     * if successful, return 0
     * increment the size
     **/
    public int addToTail(E e){
        GNode temp = new GNode(e);
        if (head == null){
            head = temp;
            tail = temp;
        }
        else{
            if (findNode(head, e) == null){
                temp.setPrevious(tail);
                tail.setNext(temp);
                tail = temp;
            }
            else return 1;
        }
        size++;
        return 0;
    }

    /** insert a new node with data e after node n
     * n is not null
     * if a node with e already exists, return 1
     * if successful, return 0
     * increment the size
     **/
    public int addAfter(GNode n, E e){
        if (n != null) {
            if (findNode(head, e) == null) {
                GNode r = n.getNext();
                GNode q = new GNode(e);
                q.setPrevious(n);
                q.setNext(r);
                r.setPrevious(q);
                n.setNext(q);
                if (tail == n) {
                    tail = q;
                }
                size++;
                return 0;
            } else {
                return 1;
            }
        } else {
            return addToTail(e);
        }
    }

    /** insert a new node with data e before node n
     * n is not null
     * if a node with e already exists, return 1
     * if successful, return 0
     * increment the size
     *
     * @param n
     *  node that node with data e will inserted before
     * @param e
     *  data that will be inserted into list
     * @return
     *  0 if successful, 1 if e already exists in list
     * @postcondition
     *  node with data e is inserted into list prior to node n
     */
    public int addBefore(GNode n, E e){
        if (n != null) {
            if (findNode(head, e) == null) {
                GNode r = n.getPrevious();
                GNode q = new GNode(e);
                q.setPrevious(r);
                q.setNext(n);
                r.setNext(q);
                n.setPrevious(q);
                if (head == n) {
                    head = q;
                }
                size++;
                return 0;
            } else {
                return 1;
            }
        } else {
            return addToHead(e);
        }
    }

    /** exchange two nodes n1 and n2
     * n1 is not null
     * n2 is not null
     *
     * @param n1
     *  GNode to be exchanged, should not be null
     * @param n2
     *  GNode to be exchanged, should not be null
     * @postcondition
     *  The two nodes are exchanged in the list.
     *  Ex. if n1 is originally at pos 1 and n2 is at pos 3,
     *  then n1 will be at pos 3 and n2 will be at pos 1.
     */
    public void exchange(GNode n1, GNode n2){
        if (n1 == null || n2 == null){ return; }
        GNode n1n = n1.getNext();
        GNode n1p = n1.getPrevious();
        GNode n2n = n2.getNext();
        GNode n2p = n2.getPrevious();
        n2p.setNext(n1);
        n1.setPrevious(n2p);
        n1.setNext(n2n);
        n2n.setPrevious(n1);
        n1p.setNext(n2);
        n2.setPrevious(n1p);
        n2.setNext(n1n);
        n1n.setPrevious(n2);
    }

    /** add a new node with e at the specified position
     * pos specifies where new node is added
     * pos of the first element in a list is 0
     * pos >= 0
     * if a node with e already exists, return 1
     * if successful, return 0
     * increment the size
     *
     * @param e
     *  object in GDList
     * @param pos
     *  integer that should be greater than zero and less than length of array
     * @return
     *  0 if succesful, 1 if node with data e already exists in list
     * @postcondition
     *  a new node is added at pos with data e
     */
    public int addPos(E e, int pos) {
        if (findNode(head, e) == null) {
            GNode current = findNodeAtPos(pos);
            GNode n = new GNode(e);
            GNode curPrev = current.getPrevious();
            n.setPrevious(curPrev);
            curPrev.setNext(n);
            n.setNext(current);
            current.setPrevious(n);
            size++;
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * replace the node at the specified position with a new node with e
     * pos specifies the position of the node to be replaced
     * pos of the first element in a list is 0
     * pos >= 0
     * if a node with e already exists, return null
     * return the pointer to the replaced node
     *
     * @param e
     *  object in GDList.
     * @param pos
     *  integer that should be greater than zero and less than length of array
     * @return
     *  replaced node
     * @postcondition
     *  a new node is added at pos with data e and replaces the node currently in that position
     */
    public GNode replacePos(E e, int pos) {
        if (head == null) { return null; }
        if (findNode(head, e) == null) {
            GNode current = findNodeAtPos(pos);
            GNode n = new GNode(e);
            GNode curPrev = current.getPrevious();
            GNode curNext = current.getNext();
            n.setPrevious(curPrev);
            curPrev.setNext(n);
            n.setNext(curNext);
            curNext.setPrevious(n);
            current.setNext(null);
            current.setPrevious(null);
            return current;
        } else {
            return null;
        }
    }

    /**
     * return the node at a given position.
     * @param pos
     *  integer that should be greater than zero and less than length of array
     * @return
     *  GNode at the given position
     * @throws ArrayIndexOutOfBoundsException
     *  If position is less than zero or greater than the length of the list, this error is thrown
     */
    public GNode findNodeAtPos(int pos) throws ArrayIndexOutOfBoundsException {
        if (pos < 0) { throw new ArrayIndexOutOfBoundsException("Position must not be negative"); }
        GNode current = head;
        int i = 0;
        while (i < pos){
            current = current.getNext();
            i++;
            if ((current == tail) && (i != pos)){
                throw new ArrayIndexOutOfBoundsException("Position must be less than list length: " + size);
            }
        }
        return current;
    }

    /** delete the node with data e
     * if a node with e does not exist, return null
     * if successful, return the pointer to the deleted node
     * decrement the size
     **/
    public GNode deleteNode(E e){
        GNode c = findNode(head, e);
        if(c != null){
            GNode n = c.getNext();
            GNode p = c.getPrevious();
            c.setNext(null);
            c.setPrevious(null);
            p.setNext(n);
            n.setPrevious(p);
            if (c == head){
                head = n;
            } else if (c == tail){
                tail = p;
            }
            size--;
        }
        return c;
    }

    /**
     * find a node with element e
     * start the search beginning at node p
     * p is not null
     * if a node with e does not exist, return null
     **/
    public GNode findNode(GNode p, E e){
        GNode current = p;
        while (current != null && current.data != e)
            current = current.getNext();
        return current;
    }

    public void printList(){
        System.out.print("Number of nodes = " + size + ", List is: ");
        if (head != null){
            GNode current = head;
            while (current != null){
                System.out.print(current.data + " ");
                current = current.getNext();
            }
        }
        else {
            System.out.println("The list is empty");
        }
    }

    public static void main(String[] args) throws Exception {

        GDList<String> names = new GDList<String>();
        GNode temp;
        names.printList();
        System.out.println();
        System.out.println("Testing deleting node that does not exist.");
        temp = names.deleteNode("Barbour");
        System.out.println(temp != null ? temp.data : "The node does not exist.");

        System.out.println("Testing replacing node in empty list");
        temp = names.replacePos("April", 1);
        System.out.println(temp != null ? temp.data : "The node does not exist.");

        GDList<String> names2 = new GDList<String>();
        names2.addBefore(null, "Kara");
        System.out.println("Second empty list, testing addBefore");
        names2.printList();
        System.out.println();

        names.addAfter(null, "April");
        System.out.println();
        names.printList();
        System.out.println();

        names.addToHead("Decker");
        names.addToHead("Barbour");
        names.addToHead("Franklin");
        System.out.println();
        names.printList();

        // find and print Decker, search from head
        System.out.println("\nFind and print Decker. Search from head.");
        temp = names.findNode(names.head, "Decker");
        System.out.println(temp != null ? temp.data : "The node does not exist.");

        System.out.println("\nFind and print Decker. Search from Barbour.");
        temp = names.findNode(names.findNode(names.head, "Barbour"), "Decker");
        System.out.println(temp != null ? temp.data : "The node does not exist.");

        System.out.println("\nFind and print Kurt. Search from head.");
        temp = names.findNode(names.head, "Kurt");
        System.out.println(temp != null ? temp.data : "The node does not exist.");

        System.out.println("\nAdd Konz after head.");
        names.addAfter(names.head, "Konz");
        temp = names.findNode(names.head, "Konz");
        System.out.println(temp != null ? temp.data : "The node does not exist.");

        names.printList();

        System.out.println("\nAdd Oliver before tail.");
        names.addBefore(names.tail, "Oliver");
        temp = names.findNode(names.head, "Oliver");
        System.out.println(temp != null ? temp.data : "The node does not exist.");

        names.printList();
        System.out.println();
        System.out.println("\nExchange Konz and Decker.");
        names.exchange(names.findNode(names.head, "Decker"), names.findNode(names.head, "Konz"));
        names.printList();
        System.out.println();
        names.exchange(null,null);
        names.printList();
        System.out.println();
        System.out.println("\nRemove Barbour.");
        temp = names.deleteNode("Barbour");
        System.out.println(temp != null ? temp.data : "The node does not exist.");

        names.printList();
        System.out.println();
        System.out.println("\nReplace position 2 with Kevin");
        temp = names.replacePos("Kevin", 2);
        System.out.println(temp != null ? temp.data : "The node does not exist.");
        names.printList();

        System.out.println("\nAdd Steph to position 2");
        int i = names.addPos("Steph", 2);
        System.out.println(temp != null ? temp.data : "The node does not exist.");
        names.printList();
    }
}