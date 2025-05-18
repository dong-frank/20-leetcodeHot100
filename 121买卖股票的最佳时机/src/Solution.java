import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int maxProfitSolutionA(int[] prices) {
        int buyDay = 0;
        int sellDay = prices.length-1;
        int max =0;
        for(int i=0 ;i<prices.length; i++){
            buyDay = findTheTopNmin(prices, i);
            if(buyDay == prices.length-1){
                continue;
            }
            int [] sellDays = Arrays.copyOfRange(prices,buyDay+1, prices.length);
            sellDay = findTheTopNmin(sellDays, sellDays.length -1);
            int profit = sellDays[sellDay] - prices[buyDay];
            if(profit >= max){
                max = profit;
            }
        }
        return max;
    }

    private int findTheTopNmin(int[] nums, int n){
        List<Integer> tmp = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            tmp.add(i);
        }
        tmp.sort(Comparator.comparingInt((Integer a) -> nums[a]).thenComparingInt(a -> a));
        return tmp.get(n);
    }

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for(int i=0; i<prices.length; i++){
            if(min > prices[i]){
                min = prices[i];
            }

            int profit = prices[i] - min;
            if(profit >= max){
                max = profit;
            }

        }
        return max;
    }


    public static void main(String[] args){
        Solution solution=new Solution();
        solution.maxProfit(new int[]{7,1,5,3,6,4});
    }
}