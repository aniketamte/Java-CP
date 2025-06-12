public class leetcode1008 {
      static class TreeNode {
            int val;
            TreeNode left, right;

            TreeNode(int val) {
                  this.val = val;
                  this.left = null;
                  this.right = null;
            }
      }
      
      public static TreeNode bstFromPreorder(int[] preorder) {
            return bst(preorder, Integer.MAX_VALUE, new int[]{0});
      }

      public static TreeNode bst(int preorder[], int bound, int[] index){
            if(index[0] == preorder.length || preorder[index[0]] > bound){
                  return null;
            }
            TreeNode root = new TreeNode(preorder[index[0]++]);
            root.left = bst(preorder, root.val, index);
            root.right = bst(preorder, bound, index);
            return root;
      }

      public static void main(String[] args) {
            int[] preorder = { 8, 5, 1, 7, 10, 12 };
            TreeNode root = bstFromPreorder(preorder);

            System.out.print("Inorder Traversal of BST: ");
            inorderTraversal(root);
      }

      // Helper method to print inorder traversal of the tree
      public static void inorderTraversal(TreeNode root) {
            if (root == null)
                  return;
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
      }
}
