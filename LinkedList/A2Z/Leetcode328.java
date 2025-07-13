public class Leetcode328 {
      public static class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                  this.val = val;
            }

            ListNode(int val, ListNode next) {
                  this.val = val;
                  this.next = next;
            }
      }
      public static ListNode oddEvenList(ListNode head){
            
            if (head == null || head.next == null){
                  return head;
            }
            ListNode odd = head;
            ListNode even = head.next;

            ListNode evenStart = head.next;

            while(even != null && even.next != null){
                  odd.next = even.next;
                  even.next = even.next.next;

                  odd = odd.next;
                  even = even.next;
            }
            odd.next = evenStart;
            return head;
      }
      
      public static void main(String[] args) {
            // Step 1: Create linked list from array [1,2,3,4,5]
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            // Step 2: Call oddEvenList function
            ListNode result = oddEvenList(head);

            // Step 3: Print result
            printList(result);
      }

      // Helper function to print the linked list
      public static void printList(ListNode head) {
            ListNode temp = head;
            while (temp != null) {
                  System.out.print(temp.val);
                  if (temp.next != null)
                        System.out.print(" -> ");
                  temp = temp.next;
            }
            System.out.println();
      }
}
