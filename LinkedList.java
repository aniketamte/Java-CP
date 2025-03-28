
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
    public static int size;

    //Add Linked List in first
    public static void addFirst(int data) {
        //create new node
        Node newNode = new Node(data);
        size++;
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
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //tail.next---. newNode
        tail.next = newNode;
        //Assign tail
        tail = newNode;
    }

    //Print LinkedList
    public void print() {
        if (head == null) {
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
    public static void addMiddle(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        //i=idx-1
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //Remove First in LL
    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    //Remove Last in LL
    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        //prev : i = size-2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    //Iterative search in LL
    public int iterativeSearch(int key){
        Node temp = head;
        int i = 0;

        while(temp != null){
            if(temp.data == key){
                //Key Found
                return i;
            }
            temp = temp.next;
            i++;
        }
        //Key not found
        return -1;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addLast(42);
        ll.addLast(52);
        ll.addLast(62);
        //   ll.print();
        //   ll.addLast(6);
        //   ll.print();
        //   System.out.println("Add in Middle of the LinkedList : ");
        //   ll.addMiddle(2, 3);
        ll.print();
        System.out.println("Size Of LL : " + ll.size);
        ll.removeFirst();
        ll.print();
        ll.removeLast();
        ll.print();

        System.out.println("Iterative Search : " + ll.iterativeSearch(3));
        System.out.println("Iterative Search : " + ll.iterativeSearch(52));
        System.out.println("Iterative Search : " + ll.iterativeSearch(10));
    }
}
