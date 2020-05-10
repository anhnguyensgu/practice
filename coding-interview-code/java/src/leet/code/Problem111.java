package leet.code;

public class Problem111 {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   * int val;
   * TreeNode left;
   * TreeNode right;
   * TreeNode(int x) { val = x; }
   * }
   */

  public int minDepth(TreeNode node) {
    if (node == null) return 0;

    boolean isLeaf = node.left == null && node.right == null;

    if (isLeaf) return 1;

    if (node.left == null) return 1 + minDepth(node.right);

    if (node.right == null) return 1 + minDepth(node.left);

    return 1 + Math.min(minDepth(node.left), minDepth(node.right));

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(0);
    System.out.println(new Problem111().minDepth(root));
  }
}
