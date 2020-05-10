package array.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
* We loop through the stream process each number
* Time complexity O(S)
* We are using array list(size = 2) to store the data
* Space complexity O(2) = O(1)
* */
public class LINETest4 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    Integer windowSize = Integer.valueOf(input.trim());
    List<Integer> q = new ArrayList<>();
    String numberStr = br.readLine();
    while (numberStr != null && numberStr.length() > 0) {
      if(q.size() < windowSize) {
        q.add(Integer.valueOf(numberStr));
        if(q.size() == windowSize) {
          System.out.println(Collections.max(q));
        }
      } else {
        q.remove(0);
        q.add(Integer.valueOf(numberStr));
        System.out.println(Collections.max(q));
      }
      numberStr = br.readLine();
    }
  }
}
