public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseListSolutionA(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode node = head;
        ListNode before = null;
        while(node!=null){
            ListNode tmp = node.next;

            node.next = before;
            before = node;
            node = tmp;

        }
        return before;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            //只有一个或一个都没有的情况
            return head;
        }
        ListNode newHead = reverseList(head.next);

        //除了head之外的其他节点已经被反转了


        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
