package leet.code;

import java.util.Map;
import java.util.TreeMap;

public class Problem665 {

  public boolean checkPossibility2(int[] nums) {
    int count = 0;
    int[] min = new int[nums.length];
    int[] max = new int[nums.length];
    min[0] = Integer.MIN_VALUE;
    max[0] = nums[0];

    if(nums[1] < nums[0]) {
      min[1] = nums[1];
      max[1] = nums[1];
      count++;
    } else {
      min[1] = nums[0];
      max[1] = nums[1];
    }

    for(int i = 2 ; i< nums.length; i++) {
      if(nums[i] < nums[i - 1]) {
        if (i >= nums.length / 2) {
          min[i] = min[i-1];
        } else {
          min[i] = min[i-1];
          max[i] = max[i-1];
        }
      } else {
        min[i] = min[i-1];
        max[i] = Math.max(max[i - 1], nums[i]);
      }
    }
    for(int i = 0 ; i< nums.length; i++) {
      if(nums[i] != max[i]) {
        count++;
      }
    }

    return count <= 1;
  }

  public boolean checkPossibility(int[] nums) {
    int count = 0;
    boolean[] state = new boolean[nums.length];
    int[] max = new int[nums.length];
    for(int i = 0; i < nums.length; i++) {
      state[i] = true;
    }
    max[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if(nums[i] < max[i - 1]) {
        int smallerCount = 0;
        int largerCount = 0;
        for(int j = i; j < nums.length; j++) {
          if(nums[j] < max[i - 1]) {
            smallerCount++;
          }
        }
        for(int j = i - 1; j >=0; j--) {
          if(nums[j] >= nums[i]) {
            largerCount++;
          }
        }
        if (smallerCount < largerCount) {
          state[i] = false;
          max[i] = max[i - 1];
        } else {
          state[i] = true;
          max[i] = nums[i];
          for(int j = i - 1; j >=0; j--) {
            if (nums[j] >= nums[i]) {
              state[j] = false;
              max[j] = nums[i];
            }
          }
        }
      } else {
        max[i] = Math.max(max[i - 1], nums[i]);
      }
    }

    for(int i = 0; i < nums.length; i++) {
      if(!state[i]) count++;
    }
    return count <= 1;
  }

  public static void main(String[] args) {
    System.out.println(new Problem665().checkPossibility(new int[]{
        1,2,5,3,3
    }));
  }
}
