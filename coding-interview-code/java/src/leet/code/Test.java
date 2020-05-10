package leet.code;

public class Test {
  static int jumpingOnClouds(int[] c) {
    int step = 0;
    int currentIndex = 0;
    String a = "";
    while(currentIndex < c.length - 1) {
      if (currentIndex + 2 >= c.length || c[currentIndex + 2] == 1) {
        if (currentIndex + 1 >= c.length || c[currentIndex + 1] == 1) {
          return 0;
        } else {
          step ++;
          currentIndex++;
        }
      } else {
        step ++;
        currentIndex += 2;
      }
    }
    return step;
  }

  public static void main(String[] args) {
    System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0}));
    System.out.println(jumpingOnClouds(new int[]{}));
    System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 1}));
  }
}
