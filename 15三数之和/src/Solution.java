import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if(nums.length <3 || nums[0] >0 || nums[nums.length-1] <0){
            return new ArrayList<>();
        }

        Set<List<Integer>> ans = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] >0){
                break;
            }
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    ans.add(tmp);

//                    while (left < right && nums[left+1] == nums[left]){
//                        left++;
//                    }
//
//                    while (left < right && nums[right-1] == nums[right]){
//                        right--;
//                    }
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else {
                    right--;
                }

            }
        }
        return ans.stream().toList();
    }

}
