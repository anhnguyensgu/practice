package array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Interval {
  public int start;
  public int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Interval{");
    sb.append("start=").append(start);
    sb.append(", end=").append(end);
    sb.append('}');
    return sb.toString();
  }
}

public class Test {


  private boolean isOverlap(Interval interval, Interval interval2) {
    if (interval2.start > interval.end) return false;
    if (interval2.end < interval.start) return false;
    return true;
  }

  private Interval merge(Interval interval, Interval interval2) {
    interval.start = Math.min(interval.start, interval2.start);
    interval.end = Math.max(interval.end, interval2.end);
    return interval;
  }
  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    Interval curInterval = newInterval;
    boolean isFound = false;
    if (intervals.size() == 0) {
      ArrayList<Interval> a = new ArrayList<>();
      a.add(newInterval);
      return a;
    }

    if (curInterval.end < intervals.get(0).start) {
      ArrayList<Interval> a = new ArrayList<>();
      a.add(newInterval);
      a.addAll(intervals);
      return a;
    }

    ArrayList<Interval> result = new ArrayList<>();
    int i;
    for(i = 0; i < intervals.size(); i++) {
      if (isOverlap(intervals.get(i), curInterval)) {
        curInterval = merge(intervals.get(i), curInterval);
        isFound = true;
      } else {
        if (isFound) result.add(curInterval);
        result.add(intervals.get(i));
//        if (curInterval.start > intervals.get(i).end) result.add(curInterval);
      }
    }
    if (!isFound) result.add(curInterval);
    for(; i< intervals.size() ; i++) {
      result.add(intervals.get(i));
    }
    return result;
  }

  public static void main(String[] args) {
    ArrayList<Interval> a = new ArrayList<>();
    a.add(new Interval(1, 2));
    a.add(new Interval(3, 6));
    System.out.println(new Test().insert(a, new Interval(8, 10)));
  }
}
