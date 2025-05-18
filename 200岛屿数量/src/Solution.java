public class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        boolean[][] hasChecked = new boolean[grid.length][grid[0].length];
        for(int i=0; i<hasChecked.length; i++){
            for (int j=0; j< hasChecked[0].length; j++){
                hasChecked[i][j] = false;
            }
        }

        for(int row=0; row<grid.length; row++){
            for (int col=0; col<grid[0].length; col++){
                if(grid[row][col] =='0'){
                    continue;
                } else if (grid[row][col] =='1' && !hasChecked[row][col]) {
                    ans+=1;
                    checkIsLand(grid,row,col,hasChecked);
                } else {
                    continue;
                }
            }
        }
        return ans;

    }

    private void checkIsLand(char[][] grid, int row, int col, boolean[][] hasChecked){
        if(grid[row][col] == '0' || hasChecked[row][col]){
            return;
        }
        hasChecked[row][col] = true;


        if(row-1!=-1){
            checkIsLand(grid, row-1, col,hasChecked);
        }
        if(row+1!=grid.length){
            checkIsLand(grid, row+1, col,hasChecked);
        }
        if(col-1!=-1){
            checkIsLand(grid, row, col-1, hasChecked);
        }
        if(col+1!=grid[0].length){
            checkIsLand(grid,row,col+1,hasChecked);
        }
        return;
    }

    public static void main(String[] args){
        char[][]grid = new char[][]{{'1','1','1'},{'0','1','0'}, {'1','1','1'}};
        Solution solution = new Solution();
        solution.numIslands(grid);
    }
}
