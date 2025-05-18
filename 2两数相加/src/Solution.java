public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;
        if (l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1!=null && l2!=null){

            node.next = new ListNode((l1.val+l2.val+carry) % 10);

            node = node.next;

            if(l1.val + l2.val + carry>=10){
                carry = 1;
            }else {
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1!=null){
            node.next = new ListNode((l1.val+carry) % 10);
            node = node.next;
            if(l1.val + carry >= 10){
                carry=1;
            }else {
                carry=0;
            }
            l1 = l1.next;
        }

        while (l2!=null){
            node.next = new ListNode((l2.val+carry) % 10);
            node = node.next;
            if(l2.val + carry >= 10){
                carry=1;
            }else {
                carry=0;
            }
            l2 = l2.next;
        }

        if(carry == 1){
            node.next = new ListNode(1);
        }

        return head.next;
    }
}
