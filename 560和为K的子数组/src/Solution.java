import java.util.HashMap;

public class Solution {
    public int subarraySumSolutionA(int[] nums, int k) {
        int ans = 0;
        int left =0;
        while (left < nums.length){
            int sum = 0;
            for(int right = left; right<nums.length; right++){
                sum+=nums[right];
                if(sum == k){
                    ans++;
                }
            }
            left++;
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        int ans = 0;
        int preSum = 0;
        for(int i=0; i<nums.length; i++){
            preSum = preSum + nums[i];
            int tmp = -k + preSum;
            hashMap.put(preSum,hashMap.getOrDefault(preSum,0)+1);
            ans += hashMap.getOrDefault(tmp, 0);
        }
        return ans;
    }

}
