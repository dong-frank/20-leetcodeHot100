import java.util.Arrays;

public class Solution {
    public int search(int[] nums, int target) {
        //找在哪里发生了旋转
        int k = 0;
        for (int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                k = i;
                break;
            }
        }

        int ans = binarySearch(nums,target,0,k);
        if(ans!=-1){
            return ans;
        }else {
            return binarySearch(nums,target,k+1,nums.length-1);
        }
    }

    private int binarySearch(int[] nums, int target, int start, int end){
        int left = start;
        int right = end;
        int ans =nums.length;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                ans= mid;
                break;
            }else if(nums[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return ans == nums.length? -1:ans;
    }
}
