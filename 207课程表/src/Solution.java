import java.util.Arrays;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //判断有无环
        //拓扑排序

        //先建立邻接矩阵
        int[][] adjMetric = new int[numCourses][numCourses];
        for(int i=0; i< prerequisites.length; i++){
            adjMetric[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }

        //记录一下每个节点的入度
        int[] inDegree = new int[numCourses];
        for(int point = 0; point<inDegree.length; point++){
            for(int j=0; j<inDegree.length; j++){
                inDegree[point] += adjMetric[j][point];
            }
        }
        if(prerequisites.length ==0){
            return true;
        }
        //开始拓扑排序
        int count = adjMetric.length;
        while (count>0){
            //任意选择一个入度为0的节点
            int point =-1;
            for(int i=0; i<inDegree.length; i++){
                if(inDegree[i] ==0){
                    point = i;
                    break;
                }
            }
            if(point == -1){
                return false;
            }

            //删除其所有的出边
            for(int j=0; j< adjMetric[point].length;j++){
                if(adjMetric[point][j] == 1){
                    adjMetric[point][j] = 0;
                    inDegree[j] -=1;
                }
            }

            //删除该节点
            inDegree[point] = -1;
            count--;
        }

        return true;

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.canFinish(2, new int[][]{{1,0}});
    }
}
