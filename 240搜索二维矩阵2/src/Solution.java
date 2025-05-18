public class Solution {
    public boolean searchMatrixSolutionA(int[][] matrix, int target) {
        int end = matrix[0].length-1;
        for(int row=0; row<matrix.length;row++){
            end = binarySearch(matrix[row],end,target);
            if(matrix[row][end] == target){
                return true;
            }
        }

        return false;
    }

    private int binarySearch(int[] array, int endBound, int target){
        int start =0;
        int end = endBound;
        int mid = (start + end) / 2;
        while (start <= end){
            mid = (start + end) / 2;
            if(array[mid] > target){
                end = mid-1;
            }else if(array[mid] == target){
                return mid;
            }else {
                start = mid+1;
            }
        }
        return mid;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[] position = new int[]{0,colLength-1};
        while (position[0]< rowLength && position[1] >= 0){
            if(matrix[position[0]][position[1]] == target){
                return true;
            }else if(matrix[position[0]][position[1]] > target){
                position[1]--;
            }else {
                position[0]++;
            }

        }
        return false;
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        solution.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19}},5);
    }
}
