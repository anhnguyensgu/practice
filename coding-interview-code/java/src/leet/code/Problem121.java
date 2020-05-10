package leet.code;

public class Problem121 {
  public int maxProfit(int[] prices) {
    int from = -1, to = -1, result = Integer.MIN_VALUE;
    for(int i = 0 ; i < prices.length; i++) {
      if(from < 0 || prices[i] < prices[from]) {
        from = i;
        to = i;
      } else if(prices[i] > prices[to]) {
        to = i;
        result = Math.max(result, prices[to] - prices[from]);
      }
    }
    return result < 0 ? 0 : result;
  }

  public static void main(String[] args) {
    System.out.println(new Problem121().maxProfit(new int[] {3,2,1}));
  }
}
