import java.util.*;

public class Solution {
    public int lengthOfLongestSubstringSolutionA(String s) {
        int length = s.length();
        int ans= 0;
        for(int i=0; i<length; i++){
            Set<Character> hashMap = new HashSet<>();
            int l = 0;
            for(int j=0; j< length-i; j++){
                if(hashMap.contains(s.charAt(i+j))){
                    break;
                }else {
                    hashMap.add(s.charAt(i+j));
                    l+=1;
                }
            }
            ans = Math.max(ans,l);
        }

        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            if(hashMap.containsKey(s.charAt(i))){
                left = Math.max(left, hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i),i);
            ans = Math.max(ans, i-left + 1);
        }
        return ans;
    }

}
