import java.util.ArrayList;
import java.util.List;


public class Solution {

    List<List<Integer>> allRow = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        generateOneRow(numRows);

        return allRow;

    }

    private List<Integer> generateOneRow(int row){
        List<Integer> ans = new ArrayList<>();
        if(row == 1){
            ans.add(1);
            allRow.add(ans);
            return ans;
        }

        List<Integer> preRow = generateOneRow(row-1);
        ans.add(1);
        for(int i=0; i<preRow.size()-1;i++){
            ans.add(preRow.get(i) + preRow.get(i+1));
        }
        ans.add(1);
        allRow.add(ans);
        return ans;
    }
}
