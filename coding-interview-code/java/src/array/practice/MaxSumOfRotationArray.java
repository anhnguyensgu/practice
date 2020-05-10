package array.practice;

public class MaxSumOfRotationArray {
  public static void main(String[] args) {
    int[] array = {8, 3, 1, 2};

    int sum = 0;
    int curSum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
      curSum += array[i] * i;
    }

    int maxSum = curSum;
    for (int i = 0; i < array.length; i++) {
      curSum += sum - array.length * array[array.length - i - 1];
      maxSum = Math.max(curSum, maxSum);
    }

    System.out.println(maxSum);
  }
}
