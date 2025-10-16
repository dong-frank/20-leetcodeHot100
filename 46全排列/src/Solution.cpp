//
// Created by Frank on 2025/10/16.
//
#include <vector>
using namespace std;
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;

        if (nums.size() == 1) {
            ans.push_back(nums);
            return ans;
        }
        for(int i=0; i<nums.size(); i++) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            vector<int> next_nums (nums.begin() + 1, nums.end());
            vector<vector<int>> next_nums_permute = permute(next_nums);
            for (auto v : next_nums_permute) {
                v.insert(v.begin(), nums[0]);
                ans.push_back(v);
            }
            nums[0] = nums[i];
            nums[i] = tmp;
        }
        return ans;
    }
};