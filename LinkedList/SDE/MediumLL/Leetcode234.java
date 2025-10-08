import java.util.ArrayList;
import java.util.List;

public class Leetcode234 {
    public class ListNode{
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

    public boolean isPalindrome(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        ListNode curr = head;
        //Stack st = new Stack<>();
        while (curr != null) {
            temp.add(curr.val);
            curr = curr.next;
        }
        
        int i = 0;
        int j = temp.size() - 1;

        while (i < j) {
            if (!temp.get(i).equals(temp.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
