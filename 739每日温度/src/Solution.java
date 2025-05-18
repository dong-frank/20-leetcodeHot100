import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++){
            while (!stack.isEmpty()){
                int[] top = stack.peek();
                if(top[1] < temperatures[i]){
                    ans[top[0]] = i - top[0];
                    stack.pop();
                }else {
                    break;
                }
            }
            stack.push(new int[]{i, temperatures[i]});
        }

        return ans;

    }


}
