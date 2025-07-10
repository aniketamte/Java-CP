public class basic{
      public static class Node{
            int data;
            Node next;
            Node prev;

            public Node(int data){
                  this.data = data;
                  this.next = null;
                  this.prev = null;
            }
      }

      public static Node head;
      public static Node tail;
      public static int size;

      //AddFirst
      public static void addFirst(int data){
            Node newNode = new Node(data);
            size++;
            if(head == null){
                  head = tail = newNode;
                  return;
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
      }
      //AddLast
      public static void addLast(int data){
            Node newNode = new Node(data);
            size++;
            if(head == null){
                  head = tail = newNode;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
      }
      //Print
      public static void print(){
            Node temp = head;
            while(temp != null){
                  System.out.print(temp.data + " <-> ");
                  temp = temp.next;
            }
            System.out.println("null");
      }

      //RemoveFirst
      public static void removeFirst(int data){
            Node newNode = new Node(data);
            if(head == null){
                  head = tail = newNode;
            }
            head = head.next;
            head.prev = null;
            size--;
      }

      //Reverse a DLL
      public static void reverse(){
            Node curr = head;
            Node prev = null;
            Node next;
            while(curr != null){
                  next = curr.next;
                  curr.next = prev;
                  curr.prev = next;
                  prev = curr;
                  curr = next;
            }
            head = prev;
      }

      public static void main(String[] args){
            basic dll = new basic();
            dll.addFirst(3);
            dll.addFirst(2);
            dll.addFirst(1);
            dll.addFirst(5);
            dll.addFirst(6);

            dll.print();
            System.out.println(dll.size);

            dll.addLast(10);
            dll.print();
            System.out.println(dll.size);

            dll.removeFirst(size);
            dll.print(); 
            System.out.println(dll.size);

            dll.reverse();
            dll.print();

      }
}