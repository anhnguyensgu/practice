package leet.code;

public class Problem904 {
  public int totalFruit(int[] tree) {
    if (tree.length == 0) return 0;

    int basket1 = tree[0];
    int count1 = 1;

    int basket2 = -1;
    int count2 = 0;

    int last = 0;

    int maxSum = count1 + count2;
    for (int i = 1; i < tree.length; i++) {
      if (tree[i] == basket1) {
        count1++;
        if (tree[last] != basket1) {
          last = i;
        }
      } else {
        if (basket2 == tree[i]) {
          count2++;
          if (tree[last] != basket2) {
            last = i;
          }
        } else {
          int c = i - last;
          if (tree[i - 1] == basket1) {
            basket2 = basket1;
            count2 = c;
            count1 = 1;
            basket1 = tree[i];
          } else if(tree[i - 1] == basket2) {
            count1 = c;
            count2 = 1;
            basket1 = tree[i];
          }
        }
      }
    }
    maxSum = Math.max(maxSum, count1 + count2);
    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println(new Problem904().totalFruit(new int[]{0, 1, 2, 2}));
  }
}
