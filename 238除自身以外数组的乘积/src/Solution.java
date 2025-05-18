public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixMul = new int[nums.length];
        int[] suffixMul = new int[nums.length];

        prefixMul[0] = 1;
        for(int i=1; i<nums.length;i++){
            prefixMul[i] = prefixMul[i-1] * nums[i-1];
        }

        suffixMul[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--){
            suffixMul[i] = suffixMul[i+1] * nums[i+1];
        }

        for(int i=0; i<nums.length;i++){
            nums[i] = prefixMul[i] * suffixMul[i];
        }

        return nums;


    }
}
