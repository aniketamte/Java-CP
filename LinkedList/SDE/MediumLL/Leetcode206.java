public class Leetcode206 {
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next); //last = future head
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        Leetcode206 obj = new Leetcode206();
        ListNode head = obj.new ListNode(1);
        head.next = obj.new ListNode(2);
        head.next.next = obj.new ListNode(3);
        head.next.next.next = obj.new ListNode(4);
        head.next.next.next.next = obj.new ListNode(5);
        head = obj.reverseList(head);

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
    }
}
