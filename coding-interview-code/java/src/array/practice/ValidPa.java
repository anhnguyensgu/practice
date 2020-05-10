package array.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ValidPa {
  public static boolean checkValidString(String s) {
    if (s.length() == 0) return true;
    if (s.length() == 1) {
      return s.charAt(0) == '*';
    }

    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') stack.add(s.charAt(i));
      else {
        if (s.charAt(i) == ')') {
          if (stack.isEmpty()) return false;
          stack.poll();
        } else {
          if (i == 0) {
            if (s.charAt(i + 1) == ')') i++;
          } else if (i == s.length() - 1) {
            if (stack.isEmpty()) return false;
            stack.poll();
          } else {

          }
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(checkValidString(""));
    System.out.println(checkValidString(")"));
    System.out.println(checkValidString("("));
    System.out.println(checkValidString("*"));
    System.out.println(checkValidString("(*)"));
    System.out.println(checkValidString("()()"));
    System.out.println(checkValidString("(*"));
//    System.out.println(checkValidString("(*))"));
//    System.out.println(checkValidString("(*))"));
  }
}
