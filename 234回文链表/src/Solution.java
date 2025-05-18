import java.util.*;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean isPalindrome(ListNode head) {
        List<Integer> helpList = new ArrayList<>();
        ListNode node = head;
        while(node!=null){
            helpList.add(node.val);
            node = node.next;
        }


        for(int i=0; i<helpList.size()/2; i++){
            if(!Objects.equals(helpList.get(i), helpList.get(helpList.size()-1 - i))){
                return false;
            }
        }
        return true;
    }

    private ListNode reverseListSolutionA(ListNode head) {
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

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        Solution solution = new Solution();
        solution.isPalindrome(a);


    }
}
