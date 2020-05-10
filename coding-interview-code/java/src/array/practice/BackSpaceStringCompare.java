package array.practice;

public class BackSpaceStringCompare {

  private static String getResult(String S) {
    StringBuilder sb = new StringBuilder();
    int backSpace1 = 0;
    for (int i = S.length() - 1; i >= 0; ) {
      if (S.charAt(i) == '#') {
        backSpace1++;
        i--;
      } else {
        while (backSpace1 != 0 && i >= 0 && S.charAt(i) != '#') {
          backSpace1--;
          i--;
        }

        if(i >= 0 && S.charAt(i) != '#') {
          sb.append(S.charAt(i));
          i--;
        }
      }
    }
    return sb.toString();
  }
  public static boolean backspaceCompare(String S, String T) {
    String t = getResult(T);
    String s = getResult(S);
    System.out.println(s);
    System.out.println(t);
    return s.equals(t);
  }

  public static void main(String[] args) {
    backspaceCompare("bxj##tw", "bxo#j##tw");
    backspaceCompare("ab##", "c#d#");
    backspaceCompare("a##c"
        ,"#a#c");
  }
}
