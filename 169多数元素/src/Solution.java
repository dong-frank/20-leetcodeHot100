public class Solution {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int candidate = nums[0];
        for(int i=0; i<nums.length; i++){
            if(candidate == nums[i]){
                vote++;
            }else {
                vote--;
            }

            if(vote <= 0){
                candidate = nums[i];
                vote = 0;
            }
        }

        return candidate;
    }
}
