public class Leetcode701 {
      static class TreeNode {
            int val;
            TreeNode left, right;

            TreeNode(int val) {
                  this.val = val;
                  this.left = null;
                  this.right = null;
            }
      }

      public static TreeNode insertIntoBST(TreeNode root, int val) {
            if(root == null){
                  return new TreeNode(val);
            }
            TreeNode curr = root;
            while(true){
                  if(curr.val <= val){
                        if(curr.right == null){
                              curr.right = new TreeNode(val);
                              return root;
                        } else{
                              curr = curr.right;
                        }
                  } else{
                        if(curr.left == null){
                              curr.left = new TreeNode(val);
                              return root;
                        } else{
                              curr = curr.left;
                        }
                  }
            } 
      }

      public static void inorder(TreeNode root) {
            if (root == null)
                  return;
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
      }

      public static void main(String[] args) {
            int[] values = { 40, 20, 60, 10, 30, 50, 70 };
            int valToInsert = 25;

            TreeNode root = null;
            for (int val : values) {
                  root = insertIntoBST(root, val);
            }

            System.out.print("Inorder before insertion: ");
            inorder(root);
            System.out.println();

            root = insertIntoBST(root, valToInsert);

            System.out.print("Inorder after inserting " + valToInsert + ": ");
            inorder(root);
            System.out.println();
      }
}
