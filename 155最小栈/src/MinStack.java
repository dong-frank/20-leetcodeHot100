import java.util.ArrayList;

public class MinStack {
    public class ListNode {
        int val;
        ListNode next;
        int min;
        ListNode(int val, int min) {
            this.val = val;
            this.min = min;
            next = null;
        }
    }

    ArrayList<ListNode> stack;
    int head;
    int min;
    public MinStack() {
        stack = new ArrayList<>();
        head=-1;
    }

    public void push(int val) {
        if(head==-1){
            min = val;
        }

        head++;
        ListNode node = new ListNode(val,Math.min(val,min));
        min = Math.min(val, min);
        stack.add(node);
    }

    public void pop() {
        stack.remove(head);
        head--;
        if(head != -1){
            min = getMin();
        }
    }

    public int top() {
        return stack.get(head).val;

    }

    public int getMin() {
        return stack.get(head).min;
    }
}
