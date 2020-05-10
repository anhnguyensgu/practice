package leet.code;

public class Problem104 {
  public int maxDepth(TreeNode node) {
    if (node == null) return 0;

    boolean isLeaf = node.left == null && node.right == null;

    if (isLeaf) return 1;

    if (node.left == null) return 1 + maxDepth(node.right);

    if (node.right == null) return 1 + maxDepth(node.left);

    return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));

  }

  public static void main(String[] args) {

  }
}
