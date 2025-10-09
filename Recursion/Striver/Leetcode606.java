public class Leetcode606 {
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

    public static String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        String result = Integer.toString(root.val);
        String Left = tree2str(root.left);
        String Right = tree2str(root.right);

        if(root.left == null && root.right == null){
            return result;
        }

        if (root.right == null) {
            return result + "(" + Left + ")";
        }
        if (root.left == null) {
            return root.val + "()" + "(" + Right + ")";
        }
        return result + "(" + Left + ")" + "(" + Right + ")";
    }

    public static void main(String[] args) {
        // Build the tree: [1,2,3,4]
        /*
                  1
                 / \
                2   3
               /
              4
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        // Convert tree to string and print
        String result = tree2str(root);
        System.out.println(result); // Output: 1(2(4))(3)
    }
}
