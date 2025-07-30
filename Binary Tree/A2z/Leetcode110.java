public class Leetcode110 {
      static class TreeNode {
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

      public static boolean isBalanced(TreeNode root) {
            return checkBalance(root) != -1;
      }

      public static int checkBalance(TreeNode root) {
            if (root == null) {
                  return 0;
            }
            int leftH = checkBalance(root.left);
            if (leftH == -1) {
                  return -1; // left subtree is not balanced
            }
            int rightH = checkBalance(root.right);
            if (rightH == -1) {
                  return -1; // right subtree is not balanced
            }
            if (Math.abs(leftH - rightH) > 1) {
                  return -1; // current node is not balanced
            }
            return Math.max(leftH, rightH) + 1;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);

            System.out.println(isBalanced(root)); // Output: true
      }
}
