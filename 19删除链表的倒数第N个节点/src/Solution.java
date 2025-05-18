public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode ans= new ListNode(0);
        ans.next = head;
        ListNode first = ans;
        ListNode end = head;
        while (n > 0 && end!=null){
            end = end.next;
            n--;
        }

        while (end!=null){
            first = first.next;
            end = end.next;
        }

        first.next = first.next.next;

        return ans.next;
    }
}
