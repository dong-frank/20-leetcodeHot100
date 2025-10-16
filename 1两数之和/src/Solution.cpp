//
// Created by Frank on 2025/10/16.
//
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> hashMap;
        vector<int> ans;
        for (int i=0; i< nums.size(); i++) {
            if (hashMap.find(target - nums[i]) != hashMap.end()) {
                ans.push_back(hashMap.at(target - nums[i]));
                ans.push_back(i);
                break;
            } else {
                hashMap[nums[i]] = i;
            }
        }

        return ans;
    }
};