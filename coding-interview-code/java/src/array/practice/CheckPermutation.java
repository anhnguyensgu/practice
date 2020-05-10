package array.practice;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
  static boolean checkPermutation(String a, String b) {
    if (a.length() != b.length()) return false;

    Map<Character, Integer> count = new HashMap<>();

    char[] chars = a.toCharArray();
    for (char c : chars) {
      if (count.containsKey(c)) {
        count.put(c, count.get(c) + 1);
      } else {
        count.put(c, 1);
      }
    }

    for(int i = 0; i < b.length(); i++) {
      if(count.containsKey(b.charAt(i))) {
        count.put(b.charAt(i), count.get(b.charAt(i)) - 1);
        if(count.get(b.charAt(i)) <= 0) {
          count.remove(b.charAt(i));
        }
      } else {
        return false;
      }
    }
    return count.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(checkPermutation("aaa", "abc"));
    System.out.println(checkPermutation("bcaa", "abcc"));
  }
}
