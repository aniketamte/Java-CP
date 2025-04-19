
public class Leetcode142 {
      //Leetcode 142
      //Linked List Cycle II
      //03-02-2025

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                length = lengthOfCycle(slow);
                break;
            }
        }
        if (length == 0) {
            return null;
        }
        //find start node
        ListNode f = head;
        ListNode s = head;
        while (length > 0) {
            s = s.next;
            length--;
        }
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    public static int lengthOfCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {  //if cycle present
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;   //cycle not present
    }

    public static void main(String[] args) {
        Leetcode142 solution = new Leetcode142();

        // Creating a linked list with a cycle: [3,2,0,-4], tail connects to index 1
        ListNode head = solution.new ListNode(3);
        ListNode second = solution.new ListNode(2);
        ListNode third = solution.new ListNode(0);
        ListNode fourth = solution.new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creating a cycle at node index 1

        ListNode cycleStart = solution.detectCycle(head);
        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle in the linked list.");
        }
    }
}
