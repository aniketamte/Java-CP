
public class Leetcode2095 {

    public class ListNode {

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

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode prevSlow = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevSlow.next = slow.next;
        //   delete(slow);
        return head;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Leetcode2095 obj = new Leetcode2095();

        // Create list: [1,3,4,7,1,2,6]
        ListNode head = obj.new ListNode(1,
                obj.new ListNode(3,
                        obj.new ListNode(4,
                                obj.new ListNode(7,
                                        obj.new ListNode(1,
                                                obj.new ListNode(2,
                                                        obj.new ListNode(6)))))));

        System.out.print("Original list: ");
        obj.printList(head);

        head = obj.deleteMiddle(head);

        System.out.print("After deleting middle: ");
        obj.printList(head);
    }
}
