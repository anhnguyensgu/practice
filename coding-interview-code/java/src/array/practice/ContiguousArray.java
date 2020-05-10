package array.practice;

public class ContiguousArray {
  static int[][] dp;

  static int recurrsionHelper(int[] nums, int start, int end) {
    int len = end - start + 1;
    if (len == 2) {
      if (nums[start] == nums[end]) {
        dp[start][end] = 0;
        return 0;
      }
      dp[start][end] = 2;
      return 2;
    }

    int left = dp[start][end - 1] == 0 ? recurrsionHelper(nums, start, end - 1) : dp[start][end - 1];
    int right = dp[start + 1][end] == 0 ? recurrsionHelper(nums, start + 1, end) : dp[start + 1][end];

    return Math.max(left, right);
  }

  static int findMaxLength(int[] nums) {
    int[] countZeros = new int[nums.length];
    int[] countOnes = new int[nums.length];
    int result = 0;
    countOnes[0] = nums[0] == 1 ? 1 : 0;
    countZeros[0] = nums[0] == 0 ? 1 : 0;
    //init
    for (int i = 1; i < nums.length; i++) {
      countOnes[i] = nums[i] == 1 ? countOnes[i - 1] + 1 : countOnes[i - 1];
      countZeros[i] = nums[i] == 0 ? countZeros[i - 1] + 1 : countZeros[i - 1];
      if (countOnes[i] == countZeros[i]) {
        result = Math.max(result, countOnes[i] + countZeros[i]);
      } else {
        if (countOnes[i] > countZeros[i])
          for (int j = i - 1; j >= 0; j--) {
            if (countOnes[j] == countZeros[i]) {
              result = Math.max(result, countOnes[j] + countZeros[i]);
              break;
            }
          }
        else
          for (int j = i - 1; j >= 0; j--) {
            if (countOnes[i] == countZeros[j]) {
              result = Math.max(result, countOnes[i] + countZeros[j]);
              break;
            }
          }
      }
//      if (countOnes > 0 && countZeros > 0) {
//        if(countOnes == countZeros) {
//          result = Math.max(countOnes + countZeros, result);
//        } else if (countOnes > countZeros) {
//          int dif = countOnes - countZeros;
//          int temp = countOnes;
//          int index = 0;
//          while(0 != dif && nums[index] != 0 && temp != countZeros) {
//            index++;
//            temp--;
//          }
//          if(temp != countZeros) {
//            continue;
//          }
//          result = Math.max(temp + countZeros, result);
//        } else {
//          int dif = countZeros - countOnes;
//          int temp = countZeros;
//          int index = 0;
//          while(dif != 0 && nums[index] != 1 && temp != countOnes) {
//            index++;
//            temp--;
//          }
//          if(temp != countOnes) {
//            continue;
//          }
//          result = Math.max(temp + countOnes, result);
//        }
//      }
    }
    return result;
//    if (nums.length < 2) return 0;
//    dp = new int[nums.length][nums.length];
//    return recurrsionHelper(nums, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    System.out.println(findMaxLength(new int[]{1,1,0,1,0,1,1,1,0}));
  }
}
