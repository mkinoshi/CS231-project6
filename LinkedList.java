
/*LinkedList.java
 *Makoto Kinosthia
 *10/05/2015
 */

 //importing all of the java.util packages
import java.util.*;

/*
 *This class keeps data as linkedlist and each data is contained as one node
 */
public class LinkedList<T> implements Iterable<T> {
    /*
     *this is a private class LLiterator and this enables to iterate LinkedList
     */
    private class LLIterator implements Iterator<T> {
        //node field which keeps track of current node
        public Node nextnode;

        /*
         *LLIterator constructor. This initialize current node to the head of the list
         */
        public LLIterator(Node head) {
            nextnode = head;
        }

        /*
         *This method return whether current node has next node or not
         */
        public boolean hasNext() {
            if (nextnode != null) {
                return true;
            } else {
                return false;
            }
        }

        /*
         *This method reassigns current node field to the next node.
         */
        public T next() {
            if (nextnode == null) {
                return null;
            }
            T newitem = nextnode.getThing();
            nextnode = nextnode.getNext();
            return newitem;
        }

        /*
         *This method has no content yet
         */
        public void remove(Object obj) {
        }

    }

    /*
     *Private Node class. this class creates each node.
     */
    private class Node {
        //Node field which points out next node
        public Node next;
        //this field keeps the content of the node
        public T tfil;
        //this field which points out the previous node
        public Node previous;

        /*
         *Node constructor
         */
        public Node(T item) {
            next =null;
            previous = null;
            tfil = item;
        }

        /*
         *this method returns the data in the node
         */
        public T getThing() {
            return tfil;
        }

        /*
         *This methods assigns new node as a next node of the current node
         */
        public void setNext(Node n) {
            next = n;
        }

        public void setPrevious(Node n){
            previous = n;
        }
        /*
         *this methods returns the next node of current node
         */
        public Node getNext() {
            return next;
        }

        public Node getPrevious() {
            return previous;
        }

    }

    //Node field of LinkedList
    private Node head;
    //this field keeps the number of nods on this list
    private int itemnum;

    /*
     *LinkedList constructor
     */
    public LinkedList() {
        head = null;
        itemnum = 0;
    }

    /*
     *this method create empty LinkedList
     */
    public void clear() {
        head = null;
        itemnum = 0;
    }

    /*
     *This methods returns the size of this linked list
     */
    public int size() {
        return itemnum;
    }

    /*
     *This method add the new data to the list as one node
     */
    public void add(T item) {
        Node newnode = new Node(item);
        if (head == null) {
            head = newnode;
        } else {
            newnode.setNext(head);
            head.setPrevious(newnode);
            head = newnode;
            itemnum += 1;
        }
    }

    public void append(T item) {
        Node newnode = new Node(item);
        Node current = this.head;
        if (current == null) {
            head = newnode;
            itemnum++;
            return;
        }
        while (current.getNext() != null) {
            current = current.getNext();
        }
        itemnum = itemnum + 1;
        current.next = newnode;
    }

    public Node getHead() {
        return head;
    }

    public T getThing(Node n) {
        return n.getThing();
    }

    public T getItem(int num) {
        Node current = this.head;
        if (num == 0) {
            return current.getThing();
        }
        while (num != 0) {
            current  = current.next;
            num--;
        }
        return current.getThing();
    }


    /*
     *This method enables to iterate the list
     */
    public Iterator iterator() {
        LLIterator newite = new LLIterator(head);
        return newite;
    }

    /*
     *This method converts from the linked list to the arrayList
     */
    public ArrayList<T> toArrayList() {
        ArrayList<T> arraylist = new ArrayList();
        for (T item: this) {
            arraylist.add(item);
        }
        return arraylist;
    }

    /*
     *This methods converts from the Linkedlist to the arraylist and shuffle that arraylsit
     */
    public ArrayList<T> toShuffledList() {
        ArrayList<T> arraylist = this.toArrayList();
        Collections.shuffle(arraylist);
        return arraylist;
    }

    public boolean remove(Object obj) {
        Node current = this.head;
        Node previous = null;
        if (current == null) {
            return false;
        }
        while (current != null) {
            if (current.getThing().equals(obj)) {
                if (current == this.head) {
                    this.head = current.next;
                    return true;
                } else if (current.next == null) {
                    previous.next = null;
                    return true;
                } else {
                    previous.next = current.getNext();
                    current.next.previous =previous;
                    return true;
                }
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        return false;
    }

    /*
     *This method is for testing this LinkedList class
     */
    public static void main(String[] args) {
            LinkedList<Integer> llist = new LinkedList<Integer>();
            llist.append(5);
            llist.append(10);
            llist.append(10);
            llist.append(20);
            llist.remove(10);
            for(Integer item: llist) {
                System.out.printf("thing %d\n", item);
            }
            LinkedList<Integer> llist1 = new LinkedList<Integer>();
            llist1.remove(10);
            for(Integer item: llist1) {
                System.out.printf("thing %d\n", item);
            }

            for (int i=0; i<20; i+=2) {
                llist.add(i);
            }
                                                                                                                                                                                                                                                                                                                                                                 System.out.printf("\nAfter setting %d\n", llist.size());
            for (Integer item: llist) {
            System.out.printf("thing %d\n", item);
            }
        }
                                                                                                                                                                                                                                                }
