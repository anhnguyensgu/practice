package array.practice;

import java.util.HashMap;
import java.util.Map;

public class MockTest {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  Map<Integer, Integer> depth;
  Map<Integer, TreeNode> parent;

  public boolean isCousins(TreeNode root, int x, int y) {
    depth = new HashMap();
    parent = new HashMap();
    dfs(root, null);
    return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
  }

  public void dfs(TreeNode node, TreeNode par) {
    if (node != null) {
      depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
      parent.put(node.val, par);
      dfs(node.left, node);
      dfs(node.right, node);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(4);
    System.out.println(new MockTest().isCousins(root, 2,3));
  }
}
