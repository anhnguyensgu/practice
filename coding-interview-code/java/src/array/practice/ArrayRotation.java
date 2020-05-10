package array.practice;

import java.util.Arrays;

public class ArrayRotation {
	private String abc;
  private static int[] rotateWithTempArray(int[] input, int d, int n) {
    int[] result = new int[n];

    int startIndex = d - 1;

    int currentIndex = 0;
    for (int i = startIndex + 1; i < n; i++) {
      result[currentIndex++] = input[i];
    }

    for (int i = startIndex; i >= 0 ; i--) {
      result[currentIndex++] = input[i];
    }
    return result;
  }

  private static void rotateWithTempArray2(int[] nums, int k) {
    for(int i = 0; i < k % nums.length; i++ ){
      int currentIndex = i + k;
      while(currentIndex != i) {
        int temp = nums[i];
        nums[i] =  nums[currentIndex];
        nums[currentIndex] = temp;
        currentIndex += k;
        if(currentIndex > nums.length - 1) {
          currentIndex -= nums.length;
        }
      }
    }
  }



  public static void main(String[] args) {
    int[] input = {1, 2, 3, 4, 5, 6, 7};
//    int[] input = {1, 2, 3, 4};
    int d = 2;
    int n = 7;

//    int[] result = rotateWithTempArray(input, d, n);
    rotateWithTempArray2(input, 3);
    for (int i = 0; i < input.length; i++) {
      System.out.print(input[i] + " ");
    }
  }
}
