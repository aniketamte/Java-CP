public class Leetcode543 {
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
      public static int diameterOfBinaryTree(TreeNode root){
            if(root == null){
                  return 0;
            }
            int leftHeight = Height(root.left);
            int leftDiameter = diameterOfBinaryTree(root.left);
            int rightHeight = Height(root.right);
            int rightDiameter = diameterOfBinaryTree(root.right);
            int selfDiameter = leftHeight + rightHeight + 1; // +1 for the root node itself
            return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
      }

      public static int Height(TreeNode root){
            if(root == null) return 0;
            int leftHeight = Height(root.left);
            int rightHeight = Height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);
            System.out.println(diameterOfBinaryTree(root));
      }
}
