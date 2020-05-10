package array.practice;

import java.util.ArrayList;
import java.util.List;

public class FindAnagram {
  public static List<Integer> checkInclusion(String s2, String s1) {
    int[] cnt = new int[128];
    for (char c : s1.toCharArray()) cnt[c - 'a']++;
    int l = 0, r = 0;
    int count = 0;
    List<Integer> result = new ArrayList<>();
    for (char c : s2.toCharArray()) {
      r++;
      if (cnt[c - 'a'] > 0) { // Can feed
        cnt[c - 'a']--;
        if ((r - l == s1.length())) {
          count++;
          result.add(l);
          cnt[s2.charAt(l++) - 'a']++;
//          return true; // Already fed in range [l,r) and is equal to len(s1) -> Mean fed all `cnt`
        }
      } else {
        cnt[c - 'a']--;
        while (s2.charAt(l) != c) cnt[s2.charAt(l++) - 'a']++;
        cnt[s2.charAt(l++) - 'a']++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(checkInclusion("abcab", "abc"));
    System.out.println(checkInclusion("cbaebabacd", "abc"));
  }
}
