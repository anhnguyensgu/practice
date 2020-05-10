package leet.code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGame2 {

  public int jump(int[] nums) {
    if (nums.length == 1) return 0;
    Queue<int[]> q = new LinkedList<>();
    int[] a = new int[]{0, nums[0], 0};
    boolean[] visited = new boolean[nums.length];
    q.add(a);
    while (!q.isEmpty()) {
      int[] firstRange = q.poll();
      for (int i = 1; i <= firstRange[1]; i++) {
        if (firstRange[0] + i == nums.length - 1) {
          return firstRange[2] + 1;
        }
        if (!visited[firstRange[0] + i]) {
          q.add(new int[]{firstRange[0] + i, nums[firstRange[0] + i], firstRange[2] + 1});
        }
      }
    }
    return -1;
  }

  int jumpWithDynamicProgramming(int[] nums) {
    int[][] matrix = new int[nums.length + 1][nums.length + 1];
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix.length; j++) {
        matrix[i][j] = Integer.MAX_VALUE;
      }
    }
    matrix[1][1] = 0;

    for (int i = 1; i <= nums.length; i++) {
      for (int j = i + 1; j <= Math.min(i + nums[i - 1], nums.length); j++) {
        if (i < 2) {
          matrix[i][j] = matrix[i][i] + 1;
        } else {
          matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][i] + 1);
        }
        matrix[j][j] = matrix[i][j];
        if(j == nums.length) return matrix[i][j];
      }
    }
    return matrix[nums.length][nums.length];
  }

  public static void main(String[] args) {
    System.out.println(new JumpGame2().jump(new int[]{1, 2, 1, 3, 1, 4}));
  }
}
