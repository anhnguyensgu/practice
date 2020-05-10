package array.practice;

public class DeleteNode {
  static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
  public static void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;

  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode p = head;
    ListNode f = head;
    int count = 0;
    while(count < n) {
      f = f.next;
      count++;
    }

    if(n == count) {
      return head.next;
    }

    if(f == null) {
      head.val = head.next.val;
      head.next = head.next.next;
      return head;
    }

    while (f.next != null) {
      f = f.next;
      p = p.next;
    }

    p.next = p.next.next;
    return head;
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
//    node.next.next = new ListNode(3);
//    node.next.next.next = new ListNode(4);
//    node.next.next.next.next = new ListNode(5);
//    deleteNode(node.next.next);
//    deleteNode(node.next);
//    deleteNode(node);
    removeNthFromEnd(node, 2);

    while(node != null) {
      System.out.println(node.val);
      node = node.next;
    }
  }
}
