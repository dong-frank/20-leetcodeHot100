public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val, int min) {
            this.val = val;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode node;
        if(list1.val < list2.val){
            node = list1;
            list1 = list1.next;
        }else {
            node = list2;
            list2 = list2.next;
        }

        ListNode next;

        ListNode ans = node;


        while (list1!=null && list2!=null){
            if(list1.val < list2.val){
                next = list1;
                list1 = list1.next;
            }else {
                next = list2;
                list2 = list2.next;
            }

            node.next = next;
            node = node.next;
        }

        if(list1!=null){
            node.next = list1;
        }

        if(list2!=null){
            node.next = list2;
        }



        return ans;
    }

}
