public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] helperArray = new boolean[matrix.length+ matrix[0].length];
        for(int row=0; row<matrix.length; row++){
            for (int col=0; col<matrix[0].length; col++){
                if(matrix[row][col] == 0){
                    helperArray[row] = true;
                    helperArray[matrix.length + col] =true;
                }
            }
        }

        for(int row=0; row<matrix.length; row++){
            for (int col=0; col<matrix[0].length; col++){
                if(helperArray[row] || helperArray[matrix.length + col]){
                    matrix[row][col] = 0;
                }
            }
        }
    }
}
