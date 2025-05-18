import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        //初始化单调队列
        for(int i=0; i<k; i++){
            while (!deque.isEmpty() &&nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[nums.length-k+1];
        ans[0] = nums[deque.peekFirst()];
        for(int i=k; i<nums.length; i++){
            while (!deque.isEmpty() &&nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);

            if(deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
