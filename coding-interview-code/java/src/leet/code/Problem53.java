package leet.code;

import java.util.Arrays;

/*
* -2, 1, -3, 4, -1, 2, 1, -5, 4}
*            ^
* */

public class Problem53 {

  static int maxSubarraySum(int[] nums) {
    return maxSubarraySum(nums, 0, nums.length - 1);
  }

  private static int maxSubarraySum(int[] nums, int low, int high) {

    if (low == high) {
      return nums[low];
    }

    int mid = (low + high) / 2;

    int maxLeftSum = maxSubarraySum(nums, low, mid);
    int maxRightSum = maxSubarraySum(nums, mid + 1, high);
    int maxCrossSum = getMaxCrossSum(nums, low, mid, high);

    return Math.max(Math.max(maxLeftSum, maxRightSum), maxCrossSum);
  }


  private static int getMaxCrossSum(int[] nums, int low, int mid, int high) {

    int leftSubMax = Integer.MIN_VALUE;
    int currSum = 0;

    for (int i = mid; i >= low; i--) {
      currSum += nums[i];
      leftSubMax = Math.max(leftSubMax, currSum);
    }

    int rightSubMax = Integer.MIN_VALUE;
    currSum = 0;
    for (int i = mid + 1; i <= high; i++) {
      currSum += nums[i];
      rightSubMax = Math.max(rightSubMax, currSum);
    }

    return leftSubMax + rightSubMax;
  }


  public int maxSubArray(int[] nums) {
    int preSum = nums[0];
    int result = preSum;
    for(int i = 1 ; i < nums.length; i++) {
      preSum = Math.max(preSum + nums[i], nums[i]);
      result = Math.max(preSum, result);
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(new Problem53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    System.out.println(maxSubarraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

  }
}
