package array.practice;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
      if(prices.length < 2) return 0;

      int buyAt = 0;
      int result = 0;
      int profit = 0;
      for(int i = 1; i < prices.length; i++) {
        if(prices[i - 1] <= prices[i]) {
          profit += prices[i] - prices[i - 1];
        } else {
          result = Math.max(result + prices[i - 1] - prices[buyAt], profit);
          buyAt = i;
          profit = 0;
        }
      }
      return Math.max(result, profit);
    }
  public static void main(String[] args) {
//    int [] prices = {7,1,5,3,6,4};
//    int [] prices = {7,1,5,3,6,4};
    int [] prices = {1,2,3,4,5};
    System.out.println(maxProfit(prices));
  }
}
