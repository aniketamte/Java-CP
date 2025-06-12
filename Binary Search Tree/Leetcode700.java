public class Leetcode700 {
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
      
      public static TreeNode searchBST(TreeNode root, int val) {
            TreeNode curr = root;
            while(curr != null){
                  if(curr.val == val){
                        return curr;
                  } else if(curr.val > val){
                        curr = curr.left;
                  } else{
                        curr = curr.right;
                  }
            }
            return curr;
      }
      
      public static void main(String[] args) {
            /*
             * Tree Structure:
             * 4
             * / \
             * 2 7
             * / \
             * 1 3
             */

            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.right = new TreeNode(7);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);

            int target = 2;
            TreeNode result = searchBST(root, target);

            if (result != null) {
                  System.out.println("Found node with value: " + result.val);
            } else {
                  System.out.println("Value " + target + " not found in BST.");
            }
      }
}
