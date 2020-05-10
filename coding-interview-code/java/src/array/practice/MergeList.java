package array.practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeList {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    ListNode result = null;
    PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparing(listNode -> listNode.val));

    for (int i = 0; i < lists.length; i++) {
      ListNode head = lists[i];
      while (head != null) {
        q.add(head);
        head = head.next;
      }
    }
    if (!q.isEmpty()) {
      result = q.poll();
    }
    while (!q.isEmpty()) {
      result.next = q.poll();
      result = result.next;
    }
    return result;
  }

  public static void main(String[] args) {
    ListNode h1 = new ListNode(1);
    h1.next = new ListNode(4);
    h1.next.next = new ListNode(5);

    ListNode h2 = new ListNode(1);
    h2.next = new ListNode(3);
    h2.next.next = new ListNode(4);

    ListNode h3 = new ListNode(1);
    h3.next = new ListNode(3);

    System.out.print(mergeKLists(new ListNode[]{h1, h2, h3}));

  }
}
