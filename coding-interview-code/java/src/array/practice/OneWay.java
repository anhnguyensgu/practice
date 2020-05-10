package array.practice;

public class OneWay {
  static void solve(String str, String str2) {
    if (str.length() == str2.length()) {
      int countDiff = 0;
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) != str2.charAt(i)) {
          countDiff++;
        }
      }
      System.out.println(countDiff <= 1);
    } else {
      if (str2.length() < str.length()) {
        int countDiff = 0;
        int fast = 0;
        for (int i = 0; i < str2.length() && fast < str.length(); i++) {
          if (str.charAt(fast) != str2.charAt(i)) {
            if (str.charAt(fast + 1) != str2.charAt(i)) {
              countDiff++;
              fast += 2;
            }
            fast++;
          } else {
            fast++;
          }
        }
        System.out.println(Math.abs(str2.length() - str.length()) <= 1 && countDiff == 0);
      } else {
        int countDiff = 0;
        for (int i = 0; i < str.length(); i++) {
          if (str.charAt(i) != str2.charAt(i)) {
            countDiff++;
          }
          System.out.println(Math.abs(str2.length() - str.length()) <= 1 && countDiff == 0);
        }
        System.out.println(Math.abs(str2.length() - str.length()) <= 1);
      }
    }
  }

  public static void main(String[] args) {
    solve("pale", "ple");
    solve("pales", "pale");
    solve("pale", "bale");
    solve("pale", "bake");
    solve("pales", "bale");
  }
}
