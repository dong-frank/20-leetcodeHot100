import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findAnagramsSolutionA(String s, String p) {
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i+ p.length() <= s.length();i++){
            String toCheck = s.substring(i,i+p.length());
            char[] tmp = toCheck.toCharArray();
            Arrays.sort(tmp);
            if(Arrays.equals(tmp, pArray)){
                ans.add(i);
            }
        }
        return ans;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] pAlphabetCount = new int[26];
        int[] sAlphabetCount = new int[26];
        for(char c :p.toCharArray()){
            pAlphabetCount[c-'a'] +=1;
        }

        int pLength = p.length();
        int sLength = s.length();

        List<Integer> ans = new ArrayList<>();
        if(sLength<pLength){
            return ans;
        }
        //初始窗口
        for(int i=0; i<pLength; i++){
            sAlphabetCount[s.charAt(i)-'a']+=1;
        }
        if(Arrays.equals(pAlphabetCount,sAlphabetCount)){
            ans.add(0);
        }

        //窗口开始滑动
        for(int i=0; i<sLength-pLength; i++){
            sAlphabetCount[s.charAt(i)-'a']-=1;
            sAlphabetCount[s.charAt(i+pLength)-'a']+=1;
            if(Arrays.equals(pAlphabetCount,sAlphabetCount)){
                ans.add(i+1);
            }
        }

        return ans;

    }


    public static void main(String[] args){
        Solution solution = new Solution();
        solution.findAnagrams("cbaebabacd","abc");
    }
}
