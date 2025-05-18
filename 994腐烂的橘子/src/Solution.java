import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshOrange = 0;
        for(int i=0; i<grid.length;i++){
            for (int j=0; j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    freshOrange++;
                }else if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }

        int minute =0;
        while (freshOrange > 0 && !queue.isEmpty()){
            minute++;
            int n = queue.size();
            for(int i=0; i<n;i++){
                int[] orange = queue.poll();
                int row = orange[0];
                int col = orange[1];
                if(row-1!=-1){
                    if(grid[row-1][col] == 1){
                        grid[row-1][col] = 2;
                        freshOrange--;
                        queue.add(new int[]{row-1,col});
                    }
                }
                if(row+1!=grid.length){
                    if(grid[row+1][col] == 1){
                        grid[row+1][col] = 2;
                        freshOrange--;
                        queue.add(new int[]{row+1,col});
                    }
                }
                if(col-1!=-1){
                    if(grid[row][col-1] == 1){
                        grid[row][col-1] = 2;
                        freshOrange--;
                        queue.add(new int[]{row,col-1});
                    }
                }
                if(col+1!=grid[0].length){
                    if(grid[row][col+1] == 1){
                        grid[row][col+1] = 2;
                        freshOrange--;
                        queue.add(new int[]{row,col+1});
                    }
                }

            }
        }

        if(freshOrange>0){
            return -1;
        }

        return minute;
    }


}
