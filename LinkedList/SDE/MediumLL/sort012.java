public class sort012 {
    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public Node segregate(Node head) {
      int count0 = 0;
      int count1 = 0;
      int count2 = 0;

      Node temp = head;
      while(temp != null){
            if(temp.data == 0){
                  count0++;
            } else if(temp.data == 1){
                  count1++;
            } else{
                  count2++;
            }
            temp = temp.next;
      }

      temp = head;
      while(temp != null){
            if(count0 != 0){
                  temp.data = 0;
                  count0--;
            } else if(count1 != 0){
                  temp.data = 1;
                  count1--;
            } else{
                  temp.data = 2;
                  count2--;
            }
            temp = temp.next;
      }
      return head;
    }

    private void printList(Node head) {
      Node temp = head;
      while(temp != null){
            System.out.print(temp.data + (temp.next != null ? " -> " : ""));
            temp = temp.next;
      }
      System.out.println();
    }

    public static void main(String[] args) {
        sort012 list = new sort012();

        // Create linked list: 1 -> 0 -> 2 -> 1 -> 2
        Node head = list.new Node(1);
        head.next = list.new Node(0);
        head.next.next = list.new Node(2);
        head.next.next.next = list.new Node(1);
        head.next.next.next.next = list.new Node(2);

        System.out.println("Original List:");
        list.printList(head);

        head = list.segregate(head);

        System.out.println("Sorted List:");
        list.printList(head);
    }
}
