import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0){
            ans.add(new ArrayList<>());
            return ans;
        }

        int[] preNums = new int[nums.length-1];
        preNums = Arrays.copyOf(nums,nums.length-1);
        List<List<Integer>> preAns = subsets(preNums);
        for(int i=0; i<preAns.size(); i++){
            ans.add(new ArrayList<>(preAns.get(i)));
            List<Integer> newSubset = new ArrayList<>(preAns.get(i));
            newSubset.add(nums[nums.length - 1]);
            ans.add(newSubset);
        }
        return ans;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.subsets(new int[]{1,2,3});
    }
}
