public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }

        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i=1; i<=amount; i++){
            int min = Integer.MAX_VALUE;
            for(int j=0; j<coins.length ; j++){
                if(coins[j] > i){
                    continue;
                }
                if(dp[i-coins[j]] == -1){
                    continue;
                }
                min = Math.min(min, dp[i - coins[j]]);
            }
            dp[i] = (1 + min) < 0 ? -1 : 1+min;
        }

        return dp[amount] < 0 ? -1 : dp[amount];

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.coinChange(new int[]{2,5}, 3);
    }
}
