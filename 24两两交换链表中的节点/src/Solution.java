public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode before = ans;
        while (head!=null && head.next!=null){
            ListNode next = head.next;
            head.next = next.next;
            before.next = next;
            next.next = head;
            before = head;
            head = head.next;
        }

        return ans.next;
    }

}
