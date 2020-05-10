package leet.code;

public class Problem125 {
  public boolean isPalindrome(String drawString) {
    if (drawString.isEmpty()) return true;
    String s = drawString.toLowerCase();
    int left = 0;
    int right = s.length() - 1;
    while (left <= right) {
      if (!Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      } else if(!Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }
      else if(s.charAt(left) != s.charAt(right)) {
        return false;
      }
      else {
        left++;
        right--;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Problem125().isPalindrome("0P"));
//    System.out.println(new Problem125().getValue('A'));
  }
}
