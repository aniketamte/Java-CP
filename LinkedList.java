
public class LinkedList {

    static class Node {

        int data;
        Node next;

        //Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    //Add in Linked List
    public static void addFirst(int data) {
        //create new node
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //newnode next ---> head
        newNode.next = head;
        //head--> newNode
        head = newNode;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
    }
}
