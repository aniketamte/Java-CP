public class Leetcode237 {
      public static class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                  val = x;
            }
      }
      public static void deleteNode(ListNode node){
            node.val = node.next.val;
            node.next = node.next.next;
      }

      public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        ListNode node = head.next; 

        deleteNode(node);

        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
    }
}
