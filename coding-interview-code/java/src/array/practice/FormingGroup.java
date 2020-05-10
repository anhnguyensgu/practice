package array.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FormingGroup {
  static long solve2(int[] arr) {
    Arrays.sort(arr);
    int power = 0;
    for (int i = 0; i < arr.length - 1; i++) {

      int smallestSum = arr[i] + arr[i + 1];

      int currentPower = 0;

      for (int j = arr.length - 1; j >= i; j--) {

        if (arr[j] <= smallestSum) {
          currentPower += arr[j];
        }
      }

      if (currentPower > power) {

        power = currentPower;

      }

    }
    return power;
  }

  static long solve(int[] arr) {
    Arrays.sort(arr);

    int start = 0;
    int currentSum = arr[0];
    int maxSum = currentSum;

    for(int i = 1; i < arr.length; i++) {
      if(arr[start] + arr[start + 1] >= arr[i]) {
        currentSum += arr[i];
        maxSum = Math.max(maxSum, currentSum);
      } else {
        int localSum = currentSum;
        while(start <= i - 1) {
          if (arr[start] + arr[start + 1] >= arr[i]) {
            localSum += arr[i];
            break;
          }
          localSum -= arr[start];
          start++;
        }
        currentSum = localSum;
        maxSum = Math.max(maxSum, currentSum);
      }
    }
    return maxSum;
  }

  private static int solveContinuous(int[] a) {
    Arrays.sort(a);

    int i = a.length - 1;
    int sum = 0;

    do {
      sum += a[i];
      i--;
    } while (i >= 0 && sum + a[i] >= sum);

    return sum;
  }

  public static void main(String[] agrs) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter wr = new PrintWriter(System.out);

    int n = Integer.parseInt(br.readLine().trim());

    int[] arr = new int[n];
    // Write your code: Read and populate data to arr

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine().trim());
    }
//    long start = System.nanoTime();
    long out_ = solve(arr);
//    System.out.println(System.nanoTime() - start);

    wr.println(out_);

    wr.close();

    br.close();
//		System.out.println(solve(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3 }));
  }
}
