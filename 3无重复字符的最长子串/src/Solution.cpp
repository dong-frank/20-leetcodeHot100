//
// Created by Frank on 2025/10/16.
//
#include <string>
#include <map>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int left = 0;
        int right = 0;
        int ans = 0;
        map<char, int> hashMap;
        while (right < s.length()) {
            if (hashMap.find(s[right]) == hashMap.end()) {
                hashMap[s[right]] = right;
                right++;
                ans = max(right - left, ans);
            }else {
                left = hashMap[s[right]] + 1;
                right = left;
                hashMap.clear();
            }
        }

        return ans;
    }
};