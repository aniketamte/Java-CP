public class BSTMinMax1 {
      static class TreeNode {
            int val;
            TreeNode left, right;

            TreeNode(int val) {
                  this.val = val;
                  this.left = null;
                  this.right = null;
            }
      }

      // Find minimum value in BST
      public static int findMin(TreeNode root) {
            if (root == null) {
                  System.out.println("Tree is empty");
                  return -1;
            }
            while (root.left != null) {
                  root = root.left;
            }
            return root.val;
      }

      // Find maximum value in BST
      public static int findMax(TreeNode root) {
            if (root == null) {
                  System.out.println("Tree is empty");
                  return -1;
            }
            while (root.right != null) {
                  root = root.right;
            }
            return root.val;
      }

      public static void main(String[] args) {
            /*
             * 8
             * / \
             * 3 10
             * / \ \
             * 1 6 14
             */
            TreeNode root = new TreeNode(8);
            root.left = new TreeNode(3);
            root.right = new TreeNode(10);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(6);
            root.right.right = new TreeNode(14);

            System.out.println("Minimum value: " + findMin(root)); // 1
            System.out.println("Maximum value: " + findMax(root)); // 14
      }
}
