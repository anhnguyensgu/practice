package array.practice;

public class URLify {
  private static void solve(String a) {
    char[] chars = a.trim().toCharArray();
    int spaces = chars.length;
    for(int i = spaces - 1; i >= 0; i--) {
      if(chars[i] == ' ') {
        spaces += 2;
      }
    }

    char[] newChars = new char[spaces];
    int p = 0;
    for(int i = 0; i < chars.length; i++) {
      if(chars[i] == ' ') {
        newChars[p++] = '%';
        newChars[p++] = '2';
        newChars[p++] = '0';
      } else {
        newChars[p++] = chars[i];
      }
    }
    System.out.println(newChars);
  }
  public static void main(String[] args) {
    solve("   Mr John Smith    ");
  }
}
