import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<int[]> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                int numberEnd = s.indexOf('[', index);
                String numberStr = s.substring(index, numberEnd);
                int number = Integer.parseInt(numberStr);
                stack.push(new int[]{numberEnd + 1, number});
                index = numberEnd + 1;
                continue;
            }

            if(s.charAt(index) == ']' && stack.size() == 1){
                int [] code = stack.pop();
                String repeatStr =s.substring(code[0],index);
                ans.repeat(decodeString(repeatStr), code[1]);
                index++;
                continue;
            }else if(s.charAt(index) == ']'){
                stack.pop();
                index++;
                continue;
            }

            if(stack.isEmpty()){
                ans.append(s.charAt(index));
                index++;
            }else {
                index++;
            }

        }

        return ans.toString();
    }





}
