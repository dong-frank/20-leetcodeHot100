public class Solution {
    public int climbStairsSolutionA(int n) {
        if(n==1){
            return 1;
        }
        if(n ==2){
            //1 + 1
            //2
            return 2;
        }
        //最后一步要么走1 要么走2
        return climbStairsSolutionA(n-2) + climbStairsSolutionA(n-1);
    }

    public int climbStairs(int n){
        int a =1;
        int b =2;
        int ans =0;
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }

        for(int i=3; i<=n; i++){
            ans = a + b;
            a = b;
            b = ans;
        }
        return ans;
    }
}
