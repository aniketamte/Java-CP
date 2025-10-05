
public class Leetcode21 {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result;
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            result = list1;
            result.next = mergeTwoLists(list1.next, list2);
        } else {
            result = list2;
            result.next = mergeTwoLists(list1, list2.next);
        }
        return result;
    }

    // Helper method to print a linked list
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
        Leetcode21 obj = new Leetcode21();

        // Example 1: list1 = [1,2,4], list2 = [1,3,4]
        ListNode list1 = obj.new ListNode(1, obj.new ListNode(2, obj.new ListNode(4)));
        ListNode list2 = obj.new ListNode(1, obj.new ListNode(3, obj.new ListNode(4)));

        ListNode merged = obj.mergeTwoLists(list1, list2);
        System.out.print("Merged list: ");
        obj.printList(merged);

        // Example 2: list1 = [], list2 = []
        ListNode list3 = null;
        ListNode list4 = null;
        ListNode merged2 = obj.mergeTwoLists(list3, list4);
        System.out.print("Merged list: ");
        obj.printList(merged2);

        // Example 3: list1 = [], list2 = [0]
        ListNode list5 = null;
        ListNode list6 = obj.new ListNode(0);
        ListNode merged3 = obj.mergeTwoLists(list5, list6);
        System.out.print("Merged list: ");
        obj.printList(merged3);
    }
}
