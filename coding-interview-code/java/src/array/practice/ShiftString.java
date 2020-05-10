package array.practice;

public class ShiftString {
  public String stringShift(String s, int[][] shift) {
    int shiftLeftCount = 0;
    int shiftRightCount = 0;
    for (int i = 0; i < shift.length; i++) {
      if (shift[i][0] == 0) {
        shiftLeftCount += shift[i][1];
      } else {
        shiftRightCount += shift[i][1];
      }
    }

    int shiftCount = Math.abs(shiftLeftCount - shiftRightCount);
    char[] letters = s.toCharArray();
    if (shiftLeftCount > shiftRightCount) {
      //rotate left shiftCount steps
      leftRotate(letters, shiftCount, letters.length);

    } else if (shiftLeftCount < shiftRightCount) {
      //rotate right shiftCount steps
      rotateRight(letters, shiftCount);
    }

    return String.valueOf(letters);

  }

  public void rotateRight(char[] nums, int k) {
    k = k % nums.length;
    int count = 0;
    for (int start = 0; count < nums.length; start++) {
      int current = start;
      char prev = nums[start];
      do {
        int next = (current + k) % nums.length;
        char temp = nums[next];
        nums[next] = prev;
        prev = temp;
        current = next;
        count++;
      } while (start != current);
    }
  }

  public void leftRotate(char[] arr, int d, int n) {
    int i, j, k;
    char temp;
    int g_c_d = gcd(d, n);
    for (i = 0; i < g_c_d; i++) {
      /* move i-th values of blocks */
      temp = arr[i];
      j = i;
      while (true) {
        k = j + d;
        if (k >= n)
          k = k - n;
        if (k == i)
          break;
        arr[j] = arr[k];
        j = k;
      }
      arr[j] = temp;
    }
  }

  int gcd(int a, int b) {
    if (b == 0)
      return a;
    else
      return gcd(b, a % b);
  }

  public static void main(String[] args) {
    int[][] shift = new int[][]{{1, 4}, {0, 5}, {0, 4}, {1, 1}, {1, 5}};
    System.out.println(new ShiftString().stringShift("mecsk", shift));
  }
}
