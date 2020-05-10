package leet.code;

public class Problem680 {
  private static boolean isPalindromeRange(String s, int start, int end) {
    while(start <= end) {
      if(s.charAt(start) != s.charAt(end)) return false;
      start++;
      end--;
    }
    return true;
  }

  public static boolean validPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left <= right) {
      if(s.charAt(left) != s.charAt(right)) {
        return isPalindromeRange(s, left, right - 1) || isPalindromeRange(s, left + 1, right);
      }
      left++; right--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(validPalindrome("abcda"));
  }
}
