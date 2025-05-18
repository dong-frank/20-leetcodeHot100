import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        //先每个候选元素选取一个看是否有满足条件的组合
        return solveHelp(candidates,target, 0);
    }

    private List<List<Integer>> solveHelp(int[] candiates, int target, int start){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=start; i<candiates.length; i++){
            int candiate = candiates[i];
            if(candiate == target){
                ans.add(new ArrayList<>(List.of(candiate)));
            }
            if(candiate > target){
                continue;
            }
            List<List<Integer>> preAns = solveHelp(candiates, target - candiate, i);
            for (List<Integer> preAn : preAns) {
                List<Integer> newAns = new ArrayList<>(preAn);
                newAns.add(candiate);
                ans.add(newAns);
            }

        }

        return ans;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.combinationSum(new int[]{8,7,4,3}, 11);
    }
}
