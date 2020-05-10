import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Test {
  static class KthLargest {
    private int k;
    private List<Integer> cache;

    public KthLargest(int k, int[] nums) {
      this.k = k;
      this.cache = new ArrayList<>();
      for(int n : nums) cache.add(n);
      cache.sort(Collections.reverseOrder());
    }

    public int add(int val) {
      cache.add(val);
      cache.sort(Comparator.reverseOrder());
      return cache.get(Math.min(k, cache.size()) - 1);
    }
  }

  public boolean isLongPressedName(String name, String typed) {
//    int[] required = new int[128];
//    int[] pressed = new int[128];
    int required = 0;
    int pressed = 0;
    while (required < name.length() && pressed < typed.length()) {
      if (name.charAt(required) == typed.charAt(pressed)) {
        int current = pressed;
        int old = required;
        while (current < typed.length() && name.charAt(required) == typed.charAt(current)) {
          current++;
        }
        while (required < name.length() && name.charAt(required) == typed.charAt(current - 1))
          required++;
        if (required - old > current - pressed) return false;
        pressed = current;
      } else {
        return false;
      }
    }
    return pressed >= typed.length() && required >= name.length();

//    for(int i = 0; i < name.length(); i++)
//    {
//      required[name.charAt(i)]++;
//    }
//
//    for(char a : typed.toCharArray())
//    {
//      pressed[a]++;
//    }
//
//    for(int i = 0; i < 128; i++)
//    {
//      if(required[i] > pressed[i]) return false;
//    }
  }

  public static void main(String[] args) {
    System.out.println(new Test().isLongPressedName("saeed",
        "ssaaedd"));
  }
}
