package designPattern.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/*

0 2 3

r[0] = |0 - 2| + |0 - 3|
r[2] = |0 - 2| + |2 - 3|
r[3] = |0 - 3| + |2 - 3|


* */


public class Test {
  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 2, 1, 5, 1};
    int[] result = new int[nums.length];
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
//    for (int i = 0; i < nums.length; i++) {
//      if (map.containsKey(nums[i])) {
//        map.get(nums[i]).add(i);
//      } else {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(i);
//        map.put(nums[i], list);
//      }
//    }
//
//    for (Integer key : map.keySet()) {
//      ArrayList<Integer> l = map.get(key);
//      if (l.size() == 1) continue;
//      if (l.size() == 2) {
//        int i = 0;
//        result[l.get(i)] += Math.abs(l.get(i) - l.get(i + 1));
//        result[l.get(i + 1)] += Math.abs(l.get(i) - l.get(i + 1));
//      } else {
//        for (int i = 0; i < l.size(); i++) {
//          if (i == l.size() - 1) {
//            result[l.get(0)] += Math.abs(l.get(0) - l.get(i));
//            result[l.get(i)] += Math.abs(l.get(0) - l.get(i));
//          } else {
//            result[l.get(i)] += Math.abs(l.get(i) - l.get(i + 1));
//            result[l.get(i + 1)] += Math.abs(l.get(i) - l.get(i + 1));
//          }
//        }
//      }
//    }

    for(int i = 0 ; i < nums.length; i++) {
      int sum = 0;
      for(int j = 0; j< nums.length; j++) {
        if(nums[i] == nums[j])
          sum+= Math.abs(i - j);
      }
      result[i] = sum;
    }

    for (int n : result) {
      System.out.println(n);
    }
  }
}
