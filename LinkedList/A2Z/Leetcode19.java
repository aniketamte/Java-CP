public class Leetcode19 {
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
      
      public static ListNode removeNthFromEnd(ListNode head, int n) {
            int L = travel_front(head);
            if (n == L) {
                  return head.next; // skip the head
            }
            int travel_front = L - n;
            ListNode temp = head;
            ListNode prev = null;
            while (travel_front > 0) {
                  prev = temp;
                  temp = temp.next;
                  travel_front--; // fix: decrement this to avoid infinite loop
            }
            prev.next = temp.next;
            return head;
      }

      public static int travel_front(ListNode head){
            int length = 0;
            while(head != null){
                  length++;
                  head = head.next;
            }
            return length;
      }
      
      public static void main(String[] args) {
            // Step 1: Create the linked list [1,2,3,4,5]
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            int n = 2; // Remove 2nd node from the end

            // Step 2: Call the function
            ListNode result = removeNthFromEnd(head, n);
            // Step 3: Print the result
            while (result != null) {
                  System.out.print(result.val);
                  if (result.next != null) {
                        System.out.print(" -> ");
                  }
                  result = result.next;
            }
            System.out.println();
      }     
}
