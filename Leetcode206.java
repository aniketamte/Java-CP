public class Leetcode206 {
    public static class Node {

        int data;
        Node next;
        //constructor

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data) {
        //create node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //step2
        newNode.next = head;
        //step 3
        head = newNode;
    }

    public static void addLast(int data) {
        //Create new Node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //step2 tail.next-> newNode
        tail.next = newNode;
        //step 3
        tail = newNode;
    }

    //Reverse LL => Recursion using => LC206
    public static void reverse(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    //Reverse LL => Recursion without using => LC206
    public static Node reverseLL(Node head) {
        if (head == null) {
            return head;
        }

        /*if(size < 2){
            return;
        }*/
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Leetcode206 list = new Leetcode206();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.display();
        reverse(head);
        list.display();
        reverseLL(head);
        list.display();
    }
}
