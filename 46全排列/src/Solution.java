import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();

        if(nums.length == 1){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[0]);
            ans.add(tmp);
            return ans;
        }

        for(int i=0; i<nums.length; i++){
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            int[] nextNums = Arrays.copyOfRange(nums,1,nums.length);
            List<List<Integer>> nextAns = permute(nextNums);
            for(List<Integer> list: nextAns){
                list.addFirst(nums[0]);
            }
            ans.addAll(nextAns);
            nums[0] = nums[i];
            nums[i] = tmp;
        }

        return ans;
    }
}
