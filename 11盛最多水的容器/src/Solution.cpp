//
// Created by Frank on 2025/10/16.
//
#include <vector>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        int ans = 0;
        int left = 0;
        int right = height.size() - 1;
        while (left <= right) {
            int h = min(height[left], height[right]);
            int x = right - left;
            ans = max (ans, h * x);
            if (height[left] < height[right]) {
                left ++;
            }else {
                right --;
            }
        }
        return ans;
    }
};
