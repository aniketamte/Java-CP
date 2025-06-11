public class Leetcode110 {
      static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int val) {
                  this.val = val;
                  this.left = null;
                  this.right = null;
            }
      }

      public static boolean isBalanced(TreeNode root) {
            return check(root) != -1;
      }

      public static int check(TreeNode root){
            if(root == null){
                  return 0;
            }
            int leftH = check(root.left);
            if(leftH == -1){
                  return -1;
            }
            int rightH = check(root.right);
            if(rightH == -1){
                  return -1;
            }
            if(Math.abs(leftH - rightH) > 1){
                  return -1;
            }
            return Math.max(leftH, rightH) + 1;
      }
      public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);

            boolean result = isBalanced(root);
            System.out.println("Is the tree balanced? " + result);
      }
}
