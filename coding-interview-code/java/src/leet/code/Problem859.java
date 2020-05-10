package leet.code;

import java.util.HashMap;
import java.util.Map;

public class Problem859 {
  public boolean buddyStrings(String A, String B) {
    if (A.length() != B.length()) return false;

    Map<Character, Integer> firstMap = new HashMap<>();
    Map<Character, Integer> secondMap = new HashMap<>();
    int diff = 0;
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) != B.charAt(i)) {
        diff++;

        if (diff > 2) return false;
      }
      if(firstMap.containsKey(A.charAt(i))) {
        firstMap.put(A.charAt(i), firstMap.get(A.charAt(i)) + 1);
      } else {
        firstMap.put(A.charAt(i), 1);
      }

      if(secondMap.containsKey(B.charAt(i))) {
        secondMap.put(B.charAt(i), secondMap.get(B.charAt(i)) + 1);
      } else {
        secondMap.put(B.charAt(i), 1);
      }
    }

     if(diff == 0) {
       if(firstMap.values().stream().noneMatch(integer -> integer >= 2))
         return false;
     }

    for (Character key : firstMap.keySet()) {
      if(!secondMap.keySet().contains(key)) return false;
      if(!firstMap.get(key).equals(secondMap.get(key))) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Problem859().buddyStrings("abab", "abab"));
  }
}

