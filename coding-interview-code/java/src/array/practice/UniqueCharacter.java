package array.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueCharacter {
  private static boolean isUnique(String string) {
    int checker = 0;
    for(int i = 0; i < string.length(); i++) {
      int cAt = string.charAt(i) - 'a';
      if((checker & 1 << cAt) != 0) return false;

      checker |= 1 << cAt;
    }
    return true;
  }

  private static boolean isUnique2(String string) {
    char[] chars = string.toCharArray();
    Arrays.sort(chars);
    for(int i = 0; i < chars.length - 1; i++) {
      if(chars[i] == chars[i + 1]) return false;
    }
    return true;
  }

  private static boolean isUnique3(String string) {
    Set<Character> characters = new HashSet<>();
    for(char a : string.toCharArray()) {
      if (characters.contains(a)) return false;
      characters.add(a);
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isUnique("abcd"));
    System.out.println(isUnique("abcdefhz"));
    System.out.println(isUnique("abcd"));
    System.out.println(isUnique("abcd"));
    System.out.println(isUnique("abcc"));
    System.out.println(isUnique("aabc"));
    System.out.println(isUnique("abbc"));
    System.out.println(isUnique("aaac"));
    System.out.println(isUnique("accc"));
    System.out.println(isUnique("abbbc"));
  }
}
