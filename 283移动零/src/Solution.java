public class Solution {
    public void moveZeroes(int[] nums) {
        int notZero = 0; //记录非0的指针
        for(int i=0 ;i<nums.length;i++){
            if(nums[i]!=0){
                nums[notZero] = nums[i];
                notZero++;
            }
        }

        for(int i=notZero; i<nums.length; i++){
            nums[i]  =0;
        }

    }

    private void swapTwoNum(int[] nums, int head, int tail){
        int tmp = nums[head];
        nums[head] = nums[tail];
        nums[tail] = tmp;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.moveZeroes(new int[]{0,1,0,3,12});
    }
}