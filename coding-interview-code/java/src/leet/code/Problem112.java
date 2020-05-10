package leet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class Problem112 {
  private Map<Integer, Map<Integer, Boolean>> resultCache = new HashMap<>();

  public boolean hasPathWithMemorization(TreeNode node, int sum) {
    if (node == null) return false;
    boolean isLeaf = node.left == null && node.right == null;
    if(isLeaf) {
      if(resultCache.get(node.val) != null) {
        if(resultCache.get(node.val).get(sum) == null) {
          resultCache.get(node.val).put(sum, sum == node.val);
        }
      } else {
        Map<Integer, Boolean> newMap = new HashMap<>();
        newMap.put(sum, sum == node.val);
        resultCache.put(node.val, newMap);
      }
      return sum == node.val;
    }

    if(resultCache.get(node.val) != null && resultCache.get(node.val).get(sum) != null) {
      return resultCache.get(node.val).get(sum);
    }
    return hasPathSum(node.left, sum - node.val) || hasPathSum(node.right, sum - node.val);
  }


  public boolean hasPathSum(TreeNode node, int sum) {
    if (node == null) return false;
    boolean isLeaf = node.left == null && node.right == null;
    if(isLeaf) return sum == node.val;
    return hasPathSum(node.left, sum - node.val) || hasPathSum(node.right, sum - node.val);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    System.out.println(new Problem112().hasPathWithMemorization( root, 3));
  }
}
