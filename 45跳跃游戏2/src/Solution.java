public class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int curDist = 0;
        int nextDist = 0;
        int ans = 0;
        for (int i=0; i<nums.length; i++){
            nextDist = Math.max(nextDist, nums[i] + i);
            if(i == curDist){
                ans++;
                curDist = nextDist;
                if(nextDist >= nums.length-1){
                    break;
                }

            }
        }
        return ans;

    }
}
