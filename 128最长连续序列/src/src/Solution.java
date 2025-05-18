import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int ans = 0;
        for(int i =0;i<nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                continue;
            }
            int pre = hashMap.getOrDefault(nums[i]-1,0);
            int next = hashMap.getOrDefault(nums[i]+1, 0);
            hashMap.put(nums[i], 1+pre+next);
            if(hashMap.containsKey(nums[i]+next)){
                hashMap.put(nums[i]+next, 1+pre+next);
            }
            if(hashMap.containsKey(nums[i]-pre)){
                hashMap.put(nums[i]-pre, 1+pre+next);
            }
            ans = Math.max(ans, 1+pre+next);
        }

        return ans;

    }

}
