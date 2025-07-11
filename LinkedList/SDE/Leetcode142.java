public class Leetcode142 {

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

      public static ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null)
                  return null;
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                  slow = slow.next;
                  fast = fast.next.next;
                  if (slow == fast) {
                        break;
                  }
            }

            if (slow != fast) {
                  return null;
            }

            ListNode p = head;
            while (p != slow) {
                  p = p.next;
                  slow = slow.next;
            }
            return p;
      }

      public static void main(String[] args) {
            ListNode node1 = new ListNode(3);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(0);
            ListNode node4 = new ListNode(-4);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node2;

            ListNode cycleNode = detectCycle(node1);

            if (cycleNode != null) {
                  System.out.println("Cycle detected at node with value: " + cycleNode.val);
            } else {
                  System.out.println("No cycle detected.");
            }
      }
}
  