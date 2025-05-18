import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNodeSolutionA(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> hashmap = new HashMap<>();
        ListNode nodeA = headA;
        do {
            hashmap.put(nodeA,nodeA.val);
            nodeA= nodeA.next;
        }while (nodeA!=null);

        ListNode nodeB = headB;
        do {
            if(hashmap.containsKey(nodeB)){
                return nodeB;
            }else {
                nodeB = nodeB.next;
            }
        }while (nodeB!=null);

        return null;

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA!=nodeB){
            if(nodeA!=null){
                nodeA = nodeA.next;
            }else {
                nodeA = headB;
            }

            if(nodeB!=null){
                nodeB = nodeB.next;
            }else {
                nodeB = headA;
            }
        }
        return nodeA;
    }

}