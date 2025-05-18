public class Solution {
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int ans = dpMax[0];
        for(int i=1; i<nums.length; i++){
            dpMax[i] = nums[i];
            dpMin[i] = nums[i];
            if(nums[i] > 0){
                dpMax[i] = Math.max(dpMax[i], dpMax[i-1] * nums[i]);
                dpMin[i] = Math.min(dpMin[i], dpMin[i-1] * nums[i]);
            }else if(nums[i] < 0){
                dpMax[i] = Math.max(dpMax[i], dpMin[i-1] * nums[i]);
                dpMin[i] = Math.min(dpMin[i], dpMax[i-1] * nums[i]);
            }
            ans = Math.max(ans,dpMax[i]);
        }

        return ans;

    }
}
