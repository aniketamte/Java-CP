
import java.util.ArrayList;
import java.util.List;

//Revision

class TreeNode {

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
//Leetcode : 145 ===> Binary Tree Postorder Traversal
//11-03-2025

public class Leetcode145 {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private static void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Leetcode145 solution = new Leetcode145();
        List<Integer> result = solution.postorderTraversal(root);

        // Printing the preorder traversal result
        System.out.println("Postorder Traversal: " + result);
    }
}
