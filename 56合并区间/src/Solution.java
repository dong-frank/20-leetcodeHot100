import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[][] merge(int[][] intervals) {
        //先对区间进行排序
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int count = 0;
        int[][] ans = new int[intervals.length][];
        ans[0] = intervals[0];

        for(int i=1; i<intervals.length; i++){
            int[] interval = intervals[i];
            if(ans[count][1] >= interval[1]){
                continue;
            }else if(ans[count][1] >= interval[0] && ans[count][1] < interval[1]){
                ans[count][1] = interval[1];
            }else if (ans[count][1] < interval[0]){
                count++;
                ans[count] = interval;
            }
        }

        return Arrays.copyOf(ans,count+1);
    }
}
