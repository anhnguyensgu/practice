package array.practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
  public static int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    for(int stone : stones) {
      q.add(stone);
    }

    while(!q.isEmpty()) {
      int y = q.poll();
      if(q.isEmpty()) {
        q.add(y);
        break;
      }
      int x = q.poll();
      if(x - y == 0) {

      } else {
        q.add(y - x);
      }
    }
    int sum = 0;
    while (!q.isEmpty()) {
      sum += q.poll();
    }
    return sum;
  }
  public static void main(String[] args) {
    System.out.println(lastStoneWeight(new int[]{10,4,2,10}));
  }
}
