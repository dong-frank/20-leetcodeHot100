import java.util.ArrayList;
import java.util.List;

public class Solution {
    int row = 0;
    int col = 0;
    int moveDirection =0; //0向右, 1向下, 2向左, 3向上
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = -1;
        int bottom = matrix.length;
        int left = -1;
        int right = matrix[0].length;
        int count = bottom*right;

        List<Integer> ans = new ArrayList<>();

        while (count > 0){
            ans.add(matrix[row][col]);
            int beforeMove = move(top,bottom,left,right);
            if(beforeMove == 0 && moveDirection==1){
                top++;
            }else if(beforeMove == 1 && moveDirection == 2){
                right--;
            }else if(beforeMove == 2 && moveDirection == 3){
                bottom--;
            }else if(beforeMove == 3 && moveDirection == 0){
                left++;
            }
            count--;
        }

        return ans;


    }

    private int move(int top, int bottom, int left, int right){
        int beforeMove = moveDirection;
        if(moveDirection == 0){
            if(col +1 == right){
                row++;
                moveDirection=1;
            }else {
                col++;
            }
        }else if(moveDirection == 1){
            if(row +1 == bottom){
                col--;
                moveDirection=2;
            }else {
                row++;
            }
        }else if(moveDirection == 2){
            if(col -1 == left){
                row--;
                moveDirection=3;
            }else {
                col--;
            }
        }else if(moveDirection == 3){
            if(row - 1 == top){
                col++;
                moveDirection=0;
            }else {
                row--;
            }
        }

        return beforeMove;
    }
}
