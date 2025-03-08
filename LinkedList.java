
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

    //Add Linked List in first
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

    //Add last in linked list
    public static void addLast(int data) {
        //create newNode
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //tail.next---. newNode
        tail.next = newNode;
        //Assign tail
        newNode = tail;
    }

    //Print LinkedList
    public void print() {
      if(head == null){
            System.out.println("LL is Empty");
            return;
      }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    //Add in Middle of the LinkedList
    public static void addMiddle(int idx, int data){
       Node newNode = new Node(data);
       Node temp = head;
       int i = 0;

       while(i < idx-1){
            temp = temp.next;
            i++;
       }

       //i=idx-1
       newNode.next = temp.next;
       temp.next = newNode;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(3);
        ll.print();
        ll.addLast(4);
        ll.print();
        ll.addLast(5);
        ll.print();
        ll.addLast(6);
        ll.print();
        System.out.println("Add in Middle of the LinkedList : ");
        ll.addMiddle(2, 9);
        ll.print();
    }
}
