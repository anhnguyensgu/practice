package leet.code;

public class Problem209 {
  public int minSubArrayLen(int s, int[] nums) {
    int sum = 0;
    int head = 0;
    int ans = Integer.MAX_VALUE;
    for(int i = 0 ; i < nums.length; i++) {
      sum += nums[i];
      while(sum >= s) {
        sum = sum - nums[head];
        ans = Math.min(ans, i - head + 1);
        head++;
      }
    }

    return ans != Integer.MAX_VALUE ? ans : 0;
  }

  public static void main(String[] args) {
    System.out.println(new Problem209().minSubArrayLen(8, new int[]{2, 3, 2, 8, 2, 3}));
    System.out.println(new Problem209().minSubArrayLen(8, new int[]{2, 3, 3, 7, 2, 3}));
    System.out.println(new Problem209().minSubArrayLen(7, new int[]{2, 3, 2, 4, 3}));
    System.out.println(new Problem209().minSubArrayLen(7, new int[]{2, 3, 7, 4, 3}));
  }
}
