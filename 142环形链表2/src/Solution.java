import java.util.HashMap;
import java.util.Map;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycleSolutionA(ListNode head) {
        Map<ListNode,Integer> hashMap= new HashMap<>();
        if(head==null){
            return null;
        }

        while (head!=null){
            if(hashMap.containsKey(head)){
                return head;
            }else {
                hashMap.put(head,head.val);
            }
            head = head.next;
        }

        return null;
    }


    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode quickNode = head;
        ListNode slowNode = head;

        while (quickNode!=null){
            if(quickNode.next==null){
                return null;
            }
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
            if(quickNode == slowNode){
                return quickNode;
            }
        }
        return null;
    }
}
