package array.practice;

public class DuplicateNumber {
  public static int findDuplicate(int[] nums) {
    long checker = 0;
    for (int i = 0; i < nums.length; i++) {
      int cAt = nums[i];
      if ((checker & 1 << cAt) != 0) return nums[i];

      checker |= 1 << cAt;
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(findDuplicate(new int[]{
        13, 6, 8, 11, 20, 17, 4, 13, 13, 13}));
  }
}
