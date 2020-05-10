package array.practice;

import java.util.Arrays;

public class CountElemetn {
  public static int countElements(int[] arr) {
    if (arr.length == 1) return 0;
    Arrays.sort(arr);
    int count = 0;
    int l = 0;
    for (int i = 1; i < arr.length - 1; i++) {
      if (arr[i] - 1 == arr[l]) {
        count += (i - l);
        l = i;
      } else if (arr[i] > arr[l]) {
        l = i;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countElements(new int[]{1, 2, 3}));
  }
}
