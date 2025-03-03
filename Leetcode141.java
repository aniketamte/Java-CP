
public class Leetcode141 {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Leetcode141 solution = new Leetcode141();

        // Creating a linked list with a cycle: [3,2,0,-4], tail connects to index 1
        ListNode head = solution.new ListNode(3);
        ListNode second = solution.new ListNode(2);
        ListNode third = solution.new ListNode(0);
        ListNode fourth = solution.new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creating a cycle at node index 1

        boolean result = solution.hasCycle(head);
        System.out.println("Does the linked list have a cycle? " + result);
    }
}
