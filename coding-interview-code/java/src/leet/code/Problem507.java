package leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem507 {
  public boolean checkPerfectNumber(int num) {
    if (num == 0 || num == 1) return false;
    int n = 1;
    double v = Math.pow(2, n) * (Math.pow(2, n+1) -1);
    while(num > v) {
      n++;
      v = Math.pow(2, n) * (Math.pow(2, n+1) -1);
    }
    return v == num;
  }

  public static void main(String[] args) {
    System.out.println(new Problem507().checkPerfectNumber(28));
    System.out.println(new Problem507().checkPerfectNumber(0));
    System.out.println(new Problem507().checkPerfectNumber(1));
    System.out.println(new Problem507().checkPerfectNumber(22));
    System.out.println(new Problem507().checkPerfectNumber(25));
  }
}
