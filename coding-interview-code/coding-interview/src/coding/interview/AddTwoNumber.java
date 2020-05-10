package coding.interview;

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

public class AddTwoNumber {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode d1 = l1;
    ListNode d2 = l2;
    ListNode result = null;
    ListNode pointer = result;
    int count = 0;
    while ((d1 != null || d2 != null)) {
      int sum = (d1 == null ? 0 :d1.val) + (d2 == null ? 0 : d2.val )+ count;
      count = 0;
      if (sum >= 10) {
        count++;
        sum = sum % 10;
      }

      if (result == null) {
        result = new ListNode(sum);
        pointer = result;
      } else {
        pointer.next = new ListNode(sum);
        pointer = pointer.next;
      }
      d1 = d1 == null ? d1 : d1.next;
      d2 = d2 == null ? d2 : d2.next;
    }
    if (count == 1) {
      pointer.next = new ListNode(count);
    }
    return result;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(8);
//    l1.next = new ListNode(9);
//    l1.next.next = new ListNode(9);
//    l1.next.next.next = new ListNode(3);

    ListNode l2 = new ListNode(9);
//    l2.next = new ListNode(9);
//    l2.next.next = new ListNode(4);
    ListNode r = new AddTwoNumber().addTwoNumbers(l1, l2);

  }
}
