import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    private void backTrack(List<String> ans, StringBuilder cur, int left, int right, int max){
        if(left == right && right == max ){
            //n个括号肯定长度为2n
            ans.add(cur.toString());
            return;
        }
        if(left < max){
            cur.append('(');
            backTrack(ans,cur,left+1,right,max);
            cur.deleteCharAt(cur.length()-1);
        }

        if(left > right && right < max){
            cur.append(')');
            backTrack(ans,cur,left,right+1,max);
            cur.deleteCharAt(cur.length()-1);
        }


    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.generateParenthesis(3);
    }
}
