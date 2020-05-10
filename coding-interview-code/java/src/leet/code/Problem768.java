package leet.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem768 {
  static class Solution1 {
    private int maxChunksToSorted(int[] arr) {
      Map<Integer, Integer> count = new HashMap<>();
      int ans = 0, nonzero = 0;

      int[] expect = arr.clone();
      Arrays.sort(expect);

      for (int i = 0; i < arr.length; ++i) {
        int x = arr[i], y = expect[i];

        count.put(x, count.getOrDefault(x, 0) + 1);
        if (count.get(x) == 0) nonzero--;
        if (count.get(x) == 1) nonzero++;

        count.put(y, count.getOrDefault(y, 0) - 1);
        if (count.get(y) == -1) nonzero++;
        if (count.get(y) == 0) nonzero--;

        if (nonzero == 0) ans++;
      }

      return ans;
    }
  }

  static class Solution2 {
    int maxChunksToSorted(int arr[]) {
      if (arr == null || arr.length == 0) {
        return 0;
      }

      // use [min,max] for each chunk
      Stack<int[]> stack = new Stack<>();

      for (int i = 0; i < arr.length; i++) {
        int min = arr[i];
        int max = arr[i];

        while (!stack.isEmpty()) {
          int[] top = stack.peek();

          if (arr[i] < top[1]) {
            min = Math.min(top[0], min);
            max = Math.max(max, top[1]);
            stack.pop();
          } else {
            break;
          }
        }

        stack.push(new int[]{min, max});
      }

      return stack.size();
    }
  }

  static class Solution3 {
    private int maxChunksToSorted(int arr[]) {
      return 0;
    }
  }


  public static void main(String[] args) {
    int arr[] = {2, 1, 3, 4, 4};
    System.out.println(new Solution1().maxChunksToSorted(arr));
    System.out.println(new Solution2().maxChunksToSorted(arr));
  }
}
