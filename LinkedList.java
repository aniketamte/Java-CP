
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

    //helper function
    public int helper(Node head, int key){
        if(head == null){
            //Key doesn't Exist
            return -1;
        }

        if(head.data == key){
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
    }

    //Recursive search in LL
    public int recursiveSearch(int key){
        return helper(head, key);
    }

    //Reverse LL using Iterative approach
    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //Find and Remove Nth node from End using Iterative Approach
    public void deleteNthfromEnd(int n){
        //Calculate Size
        int size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        //Remove first operation ==> delete head
        if(n == size){
            head = head.next;
            return;
        }

        //size-n
        int i=1;
        int iToFind = size-n;
        Node prev = head;
        while(i<iToFind){
            prev=prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    //Check LL is Palindrome or not

    //slow fast approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow;  //Slow is midNode
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //Step 1 - find Mid
        Node midNode = findMid(head);

        //Step 2 -> Reverse 2nd Half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;  //Right half head
        Node left = head;

        //Step 3 -> Check Left half and Right Half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right= right.next;
        }
        return true;
    }

    //Detect Loop in cycle
    //Floyd's Cycle Finding Algorithm

    public boolean hasCycle(Node head){
        if(head == null || head.next == null){
            return false;
        }

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    //Remove cycle in Linked list

    public static boolean removeCycle() {
        // 1. Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        Node prev = null;  // Track previous node to remove cycle

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                cycle = true;
                break;
            }
        }

        if (!cycle) {
            return false; // No cycle found
        }

        // 2. Find the start of the cycle
        slow = head;
        while (slow != fast) {
            prev = fast;  // Track last node in the cycle
            slow = slow.next;
            fast = fast.next;
        }

        // 3. Remove cycle
        prev.next = null;
        return true; // Cycle removed successfully
    }

    //Merge sort on Linked List

     public Node mergeSort(Node head){
         /*
       Step ==> 1) Find middle using slow fast
                2) left half ===> Merge sort ==> start from head
                   right half ===> Merge sort ==> start from mid.next
                3) Merge Linked List
          */

          if(head == null && head.next == null){
            return head;
          }

          Node mid = findMid(head);
          Node rightHead = mid.next;
          mid.next = null;
          Node newLeft = mergeSort(head);  //left half
          Node newRight = mergeSort(rightHead); //right half

          return merge(newLeft, newRight);
     }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
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
        System.out.println("Recursive Search : " + ll.recursiveSearch(10));
        System.out.println("Recursive Search : " + ll.recursiveSearch(52));

        System.out.println("Reverse a LinkedList");
        ll.reverse();
        ll.print();

        System.out.println("Delete Nth Node : ");
        ll.deleteNthfromEnd(3);
        ll.print();

        System.out.println("Check List is Palindrome or Not : ");
        System.out.println(ll.checkPalindrome());

        System.out.println("Detect a cycle in LinkedList : ");
        System.out.println(ll.hasCycle(head));

        System.out.println("Remove cycle in Linked List : " + ll.removeCycle());
    }
}
