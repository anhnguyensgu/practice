package array.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LINETest {

  private static String solve(String line) {
    String[] split = line.split(" ");
    StringBuilder sb = new StringBuilder();
    for(String str : split) {
      sb.append(new StringBuilder(str).reverse().toString()).append(" ");
    }
    return sb.toString().trim();
  }
  public static void main (String[] args) throws java.lang.Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer number = Integer.valueOf(br.readLine());
    while(number > 0) {
      String input = br.readLine();
      System.out.println(solve(input));
      number--;
    }
  }
}
