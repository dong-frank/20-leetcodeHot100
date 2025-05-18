import java.util.Arrays;

public class Solution {

    int mid =0;
    boolean flag = false;
    public void rotateSolutionA(int[][] matrix) {
        //找到每个位置相对于中心点的坐标
        mid = matrix.length / 2;
        flag = matrix.length % 2 ==0;

        int[][] record = new int[matrix.length][];
        for(int i=0;i<record.length;i++){
            record[i] = new int[matrix.length];
            for (int j=0;j< record.length;j++){
                record[i][j] = matrix[i][j];
            }
        }

        for(int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                int[] relative = absoluteToRelative(j,i);
                //(x,y) -> (y,-x)
                int tmp = relative[0];
                relative[0] = relative[1];
                relative[1] = -tmp;
                int[] absolute = relativeToAbsolute(relative[0],relative[1]);
                matrix[absolute[1]][absolute[0]] = record[i][j];

            }
        }
    }

    private int[] absoluteToRelative(int absoluteX, int absoluteY){
        if(!flag){
            int x = absoluteX - mid;
            int y = mid - absoluteY;
            return new int[]{x,y};
        }else {
            int x, y;
            if(absoluteX < mid){
                x = absoluteX - mid;
            }else {
                x = absoluteX - mid + 1;
            }

            if(absoluteY < mid){
                y = mid - absoluteY;
            }else {
                y = mid - 1 - absoluteY;
            }
            return new int[]{x,y};
        }
    }

    private int[] relativeToAbsolute(int relativeX, int relativeY){
        if(!flag){
            int x = relativeX + mid;
            int y = mid - relativeY;
            return new int[]{x,y};
        }else {
            int x, y;
            if(relativeX < 0){
                x = relativeX + mid;
            }else {
                x = relativeX + mid - 1;
            }

            if(0 < relativeY){
                y = mid - relativeY;
            }else {
                y = mid - 1 - relativeY;
            }
            return new int[]{x,y};
        }
    }

    public void rotate(int[][] matrix) {
        //先对矩阵进行转置
        for(int i=0; i<matrix.length; i++){
            for (int j=0; j<i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //再对每一行进行逆序
        for(int row = 0; row<matrix.length; row++){
            for(int j=0; j<matrix.length/2;j++){
                int tmp = matrix[row][j];
                matrix[row][j] = matrix[row][matrix.length-j-1];
                matrix[row][matrix.length-j-1] = tmp;
            }
        }
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        solution.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
