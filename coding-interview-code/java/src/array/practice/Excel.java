package array.practice;

public class Excel {
  public static String test(int n) {
//    if(n < 27) {
//      return (char) ((n) + 'A' - 1) + "";
//    }

    String result = "";
    while (n > 0) {
      int a = n % 26;
      char c = 'Z';
      if (a != 0) {
        c = (char) ((a) + 'A' - 1);
      }
      result = c + result;
      n = (n % 26 == 0) ? ((n/26) - 1) : n / 26;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(test(701));
    System.out.println(test(28));
    System.out.println(test(52));
  }
}
