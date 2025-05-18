import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        //用hash表加快查找
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{i, hashMap.get(target - nums[i])};
            }else {
                hashMap.put(nums[i], i);
            }
        }
        return null;
    }
}