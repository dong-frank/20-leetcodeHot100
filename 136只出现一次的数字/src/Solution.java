import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumberSolutionA(int[] nums) {
        Map<Integer, Boolean> hashMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                hashMap.remove(nums[i]);
            }else {
                hashMap.put(nums[i], false);
            }
        }
        for(int ret : hashMap.keySet()){
            return ret;
        }

        return 0;
    }

    public int singleNumber(int[] nums) {
        int ans =nums[0];
        for(int i=1; i<nums.length; i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }

}
