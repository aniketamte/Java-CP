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
            ListNode dummyHead = new ListNode(-1);
            ListNode curr = dummyHead;
            int carry = 0;

            while (l1 != null || l2 != null || carry != 0) {
                  int sum = carry;

                  if (l1 != null) {
                        sum += l1.val;
                        l1 = l1.next;
                  }

                  if (l2 != null) {
                        sum += l2.val;
                        l2 = l2.next;
                  }

                  curr.next = new ListNode(sum % 10);
                  curr = curr.next;
                  carry = sum / 10;
            }

            return dummyHead.next;
      }

      public static ListNode buildList(int[] nums) {
            ListNode dummyHead = new ListNode(-1);
            ListNode curr = dummyHead;
            for (int num : nums) {
                  curr.next = new ListNode(num);
                  curr = curr.next;
            }
            return dummyHead.next;
      }

      public static void printList(ListNode head) {
            while (head != null) {
                  System.out.print(head.val);
                  if (head.next != null) {
                        System.out.print(" -> ");
                  }
                  head = head.next;
            }
            System.out.println();
      }

      public static void main(String[] args) {
            int[] nums1 = { 2, 4, 3 };
            int[] nums2 = { 5, 6, 4 };

            ListNode l1 = buildList(nums1);
            ListNode l2 = buildList(nums2);

            ListNode result = addTwoNumbers(l1, l2);

            printList(result);
      }
}
  