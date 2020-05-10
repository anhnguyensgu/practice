package array.practice;

import java.util.Arrays;

public class Problem64 {
  int[][] dp;

  private int recur(int[][] grid, int i, int j) {
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    if (i == 0 && j == 0) return grid[i][j];
    if (i == 0) {
      dp[i][j] = grid[i][j] + recur(grid, 0, j - 1);
      return dp[i][j];
    }
    if (j == 0) {
      dp[i][j] = grid[i][j] + recur(grid, i - 1, 0);
      return dp[i][j];
    }
    dp[i][j] = grid[i][j] + Math.min(recur(grid, i - 1, j), recur(grid, i, j - 1));
    return dp[i][j];
  }

  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    dp = new int[m][n];
    for (int[] dpa : dp) {
      Arrays.fill(dpa, -1);
    }
    return recur(grid, m - 1, n - 1);
  }

  public int maxProduct(int[] nums) {

    int min = nums[0];
    int max = nums[0];
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int curMax = nums[i] * max;
      int curMin = nums[i] * min;
      max = Math.max(Math.max(curMax, curMin), nums[i]);
      min = Math.min(Math.min(curMax, curMin), nums[i]);
      result = Math.max(max, result);
    }

    return result;
  }

  public int coinChange(int[] coins, int amount) {
    int[][] dp = new int[amount + 1][coins.length];

    for(int i = 1; i <= amount; i++) {
      int min = Integer.MAX_VALUE;
      for(int j = 0; j < coins.length; j++) {
        if(i - coins[j] == 0) {
          dp[i][j] = 1;
        } else if(i - coins[j] > 0)  {
          min = Math.min(min, dp[i - coins[j]][j]);
          dp[i][j] = 1 + min;
        }
      }

//      for(int j = 0; j < coins.length; j++) dp[i][j] = 1 + min;
    }

    return dp[amount][coins.length - 1];
  }

  public static void main(String[] args) {
    System.out.println(new Problem64().coinChange(new int[]{1,2,5}, 11));
  }
}
