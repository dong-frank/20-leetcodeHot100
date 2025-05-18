import java.util.ArrayList;
import java.util.List;

public class Solution {

    private final char[][] mapTable = {
            {}, {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
            return ans;
        }
        if(digits.length() == 1){
            int charNum = (digits.charAt(0) == '7' || digits.charAt(0) == '9') ? 4 : 3;
            for(int j=0; j<charNum; j++){
                ans.add(String.valueOf(mapTable[digits.charAt(0) - '0'][j]));
            }
            return ans;
        }

        String preDigits = digits.substring(0,digits.length()-1);
        List<String> preAns = letterCombinations(preDigits);
        for(int i=0; i<preAns.size(); i++){
            String tmp = preAns.get(i);
            int charNum = (digits.charAt(digits.length()-1) == '7' || digits.charAt(digits.length()-1) == '9') ? 4 : 3;
            for(int j=0; j<charNum; j++){
                ans.add(tmp + mapTable[digits.charAt(digits.length()-1) - '0'][j]);
            }
        }
        return ans;
    }
}
