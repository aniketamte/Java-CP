public class Leetcode206 {
      public static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                  val = x;
            }
      }

      public static ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                  return head;
            }

            ListNode last = reverseList(head.next); // Last = Future Head
            head.next.next = head; // Reverse the linked list
            head.next = null; // Break the linked list
            return last;
      }

      public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head = reverseList(head);
            while (head != null) {
                  System.out.print(head.val + " ");
                  head = head.next;
            }
      }
}
