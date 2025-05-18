import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        if(length % 2 !=0){
            return false;
        }
        for(int i=0; i<length; i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else {
                if(stack.isEmpty()){
                    return false;
                }else if(s.charAt(i) == ')' && stack.peek() !='('){
                    return false;
                }else if(s.charAt(i) == ']' && stack.peek() != '['){
                    return false;
                }else if(s.charAt(i) == '}' && stack.peek() != '{'){
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
