public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int prev =nums[0];
        int cur = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            int tmp = cur;
            cur = Math.max(cur, prev + nums[i]);
            prev = tmp;
        }

        return cur;
    }
}
