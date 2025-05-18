public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //先找到在哪一行
        int[] rows = new int[matrix.length];
        for(int i=0; i<rows.length; i++){
            rows[i] = matrix[i][matrix[0].length-1];
        }

        int row = search(rows, target);
        if(row >= matrix.length){
            return false;
        }
        int[] cols = new int[matrix[0].length];
        for (int i=0; i<cols.length; i++){
            cols[i] = matrix[row][i];
        }

        int col = search(cols, target);
        if(col >= matrix[0].length){
            return false;
        }

        return matrix[row][col]==target;

    }

    private int search(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right) /2;
        while (left <= right){
            mid = (left + right) /2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    //10 11 16 20
    //7 20 50 find 10
}
