public class Leetcode98{
      static class TreeNode {
            int val;
            TreeNode left, right;

            TreeNode(int val) {
                  this.val = val;
                  this.left = null;
                  this.right = null;
            }
      }

      public static boolean isValidBST(TreeNode root) {
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
      }

      public static boolean isValid(TreeNode root, long min, long max){
            if(root == null) return true;
            if(root.val <= min || root.val >= max) return false;
            return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
      }

      public static void main(String[] args) {
            // Example 1: Valid BST
            TreeNode root1 = new TreeNode(2);
            root1.left = new TreeNode(1);
            root1.right = new TreeNode(3);

            System.out.println("Is Valid BST (Example 1): " + isValidBST(root1)); // true

            // Example 2: Invalid BST
            TreeNode root2 = new TreeNode(5);
            root2.left = new TreeNode(1);
            root2.right = new TreeNode(4);
            root2.right.left = new TreeNode(3);
            root2.right.right = new TreeNode(6);

            System.out.println("Is Valid BST (Example 2): " + isValidBST(root2)); // false
      }
}