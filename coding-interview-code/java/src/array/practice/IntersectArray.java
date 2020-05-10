package array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectArray {
  public static int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    List<Integer> result = new ArrayList<>();

    int j = 0;
    int i = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        result.add(nums1[i]);
        j++;
        i++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }
    }

    int[] a = new int[result.size()];
    for (int index = 0; index < result.size(); index++) {
      a[index] = result.get(index);
    }
    return a;
  }

  public static void main(String[] args) {
    intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
  }
}
