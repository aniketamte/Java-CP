public class Leetcode124 {
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
      
      static int maxSum;
      public static int maxPathSum(TreeNode root){
            maxSum = Integer.MIN_VALUE;
            Solve(root);
            return maxSum;
      }
      public static int Solve(TreeNode root){
            if(root == null){
                  return 0;
            }
            int left = Solve(root.left);
            int right = Solve(root.right);

            int niche = left + right + root.val;
            int one_side = Math.max(left, right) + root.val;
            int only_root_accha = root.val;
            maxSum = Math.max(maxSum, Math.max(niche, Math.max(one_side, only_root_accha)));

            return Math.max(only_root_accha, one_side);
      }
      public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            int result = maxPathSum(root);
            System.out.println("Maximum Path Sum: " + result);
      }
}
