package array.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PLPermutation {
  static void solve(String str) {
    Map<Character, Integer> count = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if (count.containsKey(str.charAt(i))) {
        int current = count.get(str.charAt(i));
        count.put(str.charAt(i), current + 1);
      } else {
        count.put(str.charAt(i), 1);
      }
    }
    int limit = 0;
    for(Character ch : count.keySet()) {
      if(count.get(ch) % 2 != 0) {
        limit++;
        if(limit > 1) {
          System.out.println("NO");
          return;
        }
      }
    }
    System.out.println("YES");
  }

  static void solve2(String str) {
    int[] letters = new int[Character.getNumericValue('z') + 1 - Character.getNumericValue('a')];

    for (int i = 0; i < str.length(); i++) {
     letters[Character.getNumericValue(str.charAt(i)) - Character.getNumericValue('a')]++;
    }

    int limit = 0;
    for(int count : letters) {
      if(count% 2 != 0) {
        limit++;
        if(limit > 1) {
          System.out.println("NO");
          return;
        }
      }
    }
    System.out.println("YES");
  }

  static void solve3(String str) {
    int bitSet = 0;

    for(int i = 0; i < str.length(); i++) {
      int mask = 1 << str.charAt(i);
      bitSet = bitSet ^ mask;
    }
    if ((bitSet & (bitSet - 1)) == 0) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String name = br.readLine();
    solve3(name);
    br.close();
  }
}
