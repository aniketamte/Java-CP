public class Leetcode106{
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

      public static TreeNode solve(int inOrder[], int postOrder[], int inStart, int inEnd, int postStart, int postEnd){
            if(inStart > inEnd){
                  return null;
            }

            TreeNode root = new TreeNode(postOrder[postEnd]);

            int i = inStart;
            for(; i<= inEnd; i++){
                  if(inOrder[i] == root.val){
                        break;
                  }
            }

            int leftSize = i - inStart;
            int rightSize = inEnd - i;

            root.left = solve(inOrder, postOrder, inStart, i - 1, postStart, postStart + leftSize - 1);

            root.right = solve(inOrder, postOrder, i + 1, inEnd, postEnd-rightSize, postEnd-1);

            return root;
      }

      public static TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length;
            
            int inStart = 0;
            int inEnd = n - 1;

            int postStart = 0;
            int postEnd = n - 1;

            return solve(inorder, postorder, inStart, inEnd, postStart, postEnd);
      }

      public static void preorder(TreeNode root) {
            if (root == null)
                  return;
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
      }
      
      public static void main(String[] args) {
            int[] inorder = {9, 3, 15, 20, 7};
            int[] postorder = {9, 15, 7, 20, 3};
    
            TreeNode root = buildTree(inorder, postorder);
    
            System.out.print("Preorder of constructed tree: ");
            preorder(root);  // Expected output: 3 9 20 15 7
      }
}