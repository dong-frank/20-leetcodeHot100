public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j * j <=i; j++){ //枚举 1 ~ sqrt(i)
                min = Math.min(min, dp[i - j*j]);
            }

            dp[i] = min + 1; // 把这个数拆成了 j 和 最小完全平方数的 i-j
        }

        return dp[n];

    }
}
