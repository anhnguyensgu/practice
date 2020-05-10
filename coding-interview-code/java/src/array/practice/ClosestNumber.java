package array.practice;

public class ClosestNumber {
  public static int[] closestDivisors(int num) {
    double range = Math.sqrt(num + 2) + 1;
    for (int i = (int) range; i >= 0; i--) {
      if ((num + 2) % i == 0) {
        return new int[] {(num + 2) / i, i};
      }
      if ((num + 1) % i == 0) {
        return new int[] {(num + 1) / i, i};
      }
    }
    return new int[2];
  }

  public static void main(String[] args) {
    for (int i : closestDivisors(123)) {
      System.out.println(i);
    }
  }
}
