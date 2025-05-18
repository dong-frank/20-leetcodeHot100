public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }

        int left = binarySearchLeft(nums, target);
        int right = binarySearchRight(nums, target);
        if(left >= nums.length ){
            //没有目标元素
            return new int[]{-1, -1};
        }

        return new int[]{left, right};

    }

    private int binarySearchLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int ans = nums.length;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                ans = mid;
                right = mid-1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return ans;
    }

    private int binarySearchRight(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int ans = nums.length;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                ans = mid;
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.searchRange(new int[]{5,7,7,8,8,10},8);
    }
}
