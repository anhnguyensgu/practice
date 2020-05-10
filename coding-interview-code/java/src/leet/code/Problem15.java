package leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem15 {

  public List<List<Integer>> threeSum2(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) { // i:start pointer of array
      if (nums[i] > 0) {
        break;
      }
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      int j = i + 1; //j:second pointer of array initialized with value bigger than start pointer
      int k = nums.length - 1; //k:third pointer of array initialized with end index of array
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < 0) { //move j behind
          j++; //each moved value should be used to calculate sum value
        } else if (sum > 0) { //move k forward
          k--;
        } else {
          result.add(Arrays.asList(nums[i], nums[j], nums[k]));
          while (j < k && nums[j] == nums[j + 1]) { //remove duplicate value of left array,move j behind
            j++;
          }
          while (j < k && nums[k] == nums[k - 1]) { //remove duplicate value of right array,move k forward
            k--;
          }
          j++; //before this line, nums[j] is the last same value compared with num[j-1], so continue move behind is required.
          k--; //before this line, nums[k] is the last same value compared with nums[k-1], so continue move forward is required.
        }
      }
    }
    return result;
  }

  public List<List<Integer>> threeSum(int[] nums) {
    ArrayList<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) break;
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      int head = i + 1;
      int tail = nums.length - 1;
      int remaining = 0 - nums[i];
      while (head < tail) {
        int subSum = nums[head] + nums[tail];
        if (subSum < remaining) {
          head++;
          continue;
        }

        if (subSum > remaining) {
          tail--;
          continue;
        }

        result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
        while (head < tail && nums[head] == nums[head + 1]) { //remove duplicate value of left array,move j behind
          head++;
        }
        while (head < tail && nums[tail] == nums[tail - 1]) { //remove duplicate value of right array,move k forward
          tail--;
        }
        tail--;
        head++;
      }
    }

    return result;
  }


  public static void main(String[] args) {
    System.out.println(new Problem15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
  }
}
