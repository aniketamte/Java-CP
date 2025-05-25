public class Leetcode606 {
      static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int val) {
                  this.val = val;
            }
      }
      public String tree2str(TreeNode root){
            if(root == null) return "";
            String result = Integer.toString(root.val);
            String l = tree2str(root.left);
            String r = tree2str(root.right);
            if (root.left == null && root.right == null) {
                  return result;
            }
            if (root.right == null) {
                  return result + "(" + l + ")";
            }

            if (root.left == null) {
                  return result + "()" + "(" + r + ")";
            }
            return result + "(" + l + ")" + "(" + r + ")";
      }
      public static void main(String[] args) {
            Leetcode606 leetcode606 = new Leetcode606();
            TreeNode root = new TreeNode(1);
            //root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            String result = leetcode606.tree2str(root);
            System.out.println(result);
      }
}
