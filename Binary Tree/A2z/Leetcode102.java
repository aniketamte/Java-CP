import java.util.*;

public class Leetcode102 {
      public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                  this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                  this.val = val;
                  this.left = left;
                  this.right = right;
            }
      }

      public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null)
                  return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                  int levelSize = queue.size();
                  List<Integer> level = new ArrayList<>();
                  for (int i = 0; i < levelSize; i++) {
                        TreeNode current = queue.poll();
                        level.add(current.val);
                        if (current.left != null)
                              queue.offer(current.left);
                        if (current.right != null)
                              queue.offer(current.right);
                  }
                  result.add(level);
            }

            return result;
      }

      public static void main(String[] args) {
            Leetcode102 obj = new Leetcode102();

            // Example 1: [3,9,20,null,null,15,7]
            TreeNode root1 = obj.new TreeNode(3);
            root1.left = obj.new TreeNode(9);
            root1.right = obj.new TreeNode(20);
            root1.right.left = obj.new TreeNode(15);
            root1.right.right = obj.new TreeNode(7);

            System.out.println("Output 1: " + obj.levelOrder(root1));

            // Example 2: [1]
            TreeNode root2 = obj.new TreeNode(1);
            System.out.println("Output 2: " + obj.levelOrder(root2));

            // Example 3: []
            TreeNode root3 = null;
            System.out.println("Output 3: " + obj.levelOrder(root3));
      }
}
