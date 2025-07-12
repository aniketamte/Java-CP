public class Leetcode2 {
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

      public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyNode = new ListNode(-1);
            ListNode curr = dummyNode;
            int carry = 0;

            while (l1 != null || l2 != null) {
                  int sum = carry;

                  if (l1 != null) {
                        sum += l1.val;
                        l1 = l1.next;
                  }

                  if (l2 != null) {
                        sum += l2.val;
                        l2 = l2.next;
                  }

                  carry = sum / 10;
                  curr.next = new ListNode(sum % 10);
                  curr = curr.next;
            }

            if (carry != 0) {
                  curr.next = new ListNode(carry);
            }

            return dummyNode.next;
      }

      // Helper to print a ListNode
      public static void printList(ListNode head) {
            while (head != null) {
                  System.out.print(head.val);
                  if (head.next != null)
                        System.out.print(" -> ");
                  head = head.next;
            }
            System.out.println();
      }

      public static void main(String[] args) {
            // l1 = [2,4,3]
            ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

            // l2 = [5,6,4]
            ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

            ListNode result = addTwoNumbers(l1, l2);

            System.out.print("Output: ");
            printList(result); // Expected: 7 -> 0 -> 8
      }
}
