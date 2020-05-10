package coding.interview;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    int[] indexes = new int[2];
    for(int i = 0; i < nums.length; i++) {
      for(int j = 0; j < nums.length; j++) {
        if (i != j && nums[i] + nums[j] == target) {
          indexes[0] = i;
          indexes[1] = j;
          return indexes;
        }
      }
    }
    return indexes;
  }
  public static void main(String[] args) {
    TwoSum main = new TwoSum();
    int []result = main.twoSum(new int[]{-1, -2, -3, -4, -5}, -8);
    for (int a : result) {
      System.out.println(a);
    }
  }
}
