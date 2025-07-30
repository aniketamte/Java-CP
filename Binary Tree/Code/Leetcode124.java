public class Leetcode124 {
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

      static int maxSum;

      public static int maxPathSum(TreeNode root){
            maxSum = Integer.MIN_VALUE;
            solve(root);
            return maxSum;
      }

      public static int solve(TreeNode root){
            if(root == null) return 0;
            int left = solve(root.left);
            int right = solve(root.right);

            int niche_hi_milgaya_ans = left + right + root.val;

            int koi_ek_accha = Math.max(left, right) + root.val;

            int only_root_accha = root.val;

            maxSum = Math.max(maxSum, Math.max(niche_hi_milgaya_ans, Math.max(koi_ek_accha, only_root_accha)));

            return Math.max(koi_ek_accha, only_root_accha);
      }
      public static void main(String[] args) {
            TreeNode root = new TreeNode(-10);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);

            int result = maxPathSum(root);
            System.out.println("Maximum Path Sum: " + result);
      }
}
