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
    public boolean hasCycleSolutionA(ListNode head) {
        Map<ListNode,Integer> hashMap= new HashMap<>();
        if(head==null){
            return false;
        }

        while (head!=null){
            if(hashMap.containsKey(head)){
                return true;
            }else {
                hashMap.put(head,head.val);
            }
            head = head.next;
        }

        return false;
    }

    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode quickNode = head;
        ListNode slowNode = head;

        while (quickNode!=null){
            if(quickNode.next==null){
                return false;
            }
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
            if(quickNode == slowNode){
                return true;
            }
        }
        return false;
    }
}
