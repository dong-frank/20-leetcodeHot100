public class Solution {
    public int trap(int[] height) {
        int left =0;
        int right = height.length-1;
        int ans =0;
        int leftHeightMax = height[left];
        int rightHeightMax = height[right];

        while (left < right){
            leftHeightMax = Math.max(leftHeightMax, height[left]);
            rightHeightMax = Math.max(rightHeightMax,height[right]);
            if(leftHeightMax < rightHeightMax){ //保证了leftHeightMax < rightHeightMax
                ans += leftHeightMax - height[left];
                left++;
            }else {
                ans += rightHeightMax - height[right];
                right--;
            }
        }


        return ans;

    }
}
