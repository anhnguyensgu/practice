package array.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LINETest3 {
  public static void main (String[] args) throws java.lang.Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String[] lengthStr = input.split(" ");
    int[] sticks = new int[lengthStr.length];
    for(int i = 0; i < sticks.length; i++) {
      sticks[i] = Integer.valueOf(lengthStr[i]);
    }
    int target = Integer.valueOf(br.readLine());


    int l = 0;
    int r = sticks.length - 1;
    Arrays.sort(sticks);
    int[] result = new int[2];
    result[0] = -1;
    while (l <= r) {
      int totalLength = sticks[l] + sticks[r];
      if(totalLength == target) {
        result[0] = sticks[l];
        result[1] = sticks[r];
        break;
      }

      if(totalLength < target) {
        l++;
      } else if(totalLength > target) {
        r--;
      }
    }
    if(result[0] == -1) {
      System.out.println(result[0]);
    } else {
      System.out.println(result[0] + " " + result[1]);
    }
  }
}

