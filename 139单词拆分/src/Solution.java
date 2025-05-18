import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> dp = new HashMap<>();
        if(s.isEmpty()){
            return false;
        }

        dp.put("",true);

        for(int i=1; i<=s.length(); i++){
            String si = s.substring(0,i);
            boolean tmp = false;
            for(int j=0; j<wordDict.size(); j++){
                String word = wordDict.get(j);
                int firstWord = si.indexOf(word);
                while (firstWord != -1 && !tmp){
                    String sBefore = si.substring(0,firstWord);
                    String sAfter = si.substring(firstWord+word.length());
                    tmp = dp.getOrDefault(sBefore,false) && dp.getOrDefault(sAfter,false);
                    firstWord = si.indexOf(word, firstWord+1);
                }

                if(tmp){
                    break;
                }
            }

            dp.put(si,tmp);
        }
        return dp.get(s);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("cat");
        wordDict.add("dog");
        wordDict.add("ski");
        solution.wordBreak("catskicatcats", wordDict);
    }
}
