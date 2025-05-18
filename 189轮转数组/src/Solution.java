import java.util.Arrays;

public class Solution {
    public void rotate(int[] nums, int k) {
        int[] newNums = new int[nums.length];

        k = k % nums.length;
        int step = 0;
        for(int i= nums.length-k; i< nums.length; i++){
            newNums[step] = nums[i];
            step++;
        }

        for(int i=0; step < newNums.length; i++){
            newNums[step] = nums[i];
            step++;
        }

        for(int i=0; i<nums.length;i++){
            nums[i] = newNums[i];
        }

    }
}
