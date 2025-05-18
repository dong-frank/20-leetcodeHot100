public class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        if(nums.length == 1){
            return true;
        }

        if(max <=0){
            return false;
        }
        for(int i=1; i<nums.length-1; i++){
            max-=1;
            max = Math.max(max, nums[i]);
            if(max <=0){
                return false;
            }
        }

        return true;

    }
}
