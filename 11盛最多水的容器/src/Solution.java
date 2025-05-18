public class Solution {
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int h = Math.min(height[left], height[right]);
        int x = right - left;
        int ans = h * x;
        while (left < right){
            if(height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
            h = Math.min(height[left], height[right]);
            x = right - left;
            ans = Math.max(ans, h*x);
        }

        return ans;
    }
}
