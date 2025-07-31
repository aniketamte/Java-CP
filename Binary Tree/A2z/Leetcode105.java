import java.util.LinkedList;
import java.util.Queue;

public class Leetcode105 {
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
      
      static int preorderIndex;

      public static TreeNode buildTree(int[] preorder, int[] inorder) {
            preorderIndex = 0;
            return solve(preorder, inorder, 0, inorder.length - 1);
      }

      public static TreeNode solve(int[] preorder, int[] inorder, int start, int end) {
            if (start > end) {
                  return null;
            }

            int rootVal = preorder[preorderIndex++];
            TreeNode root = new TreeNode(rootVal);

            // Find rootVal in inorder[]
            int i = start;
            while (i <= end) {
                  if (inorder[i] == rootVal)
                        break;
                  i++;
            }

            root.left = solve(preorder, inorder, start, i - 1);
            root.right = solve(preorder, inorder, i + 1, end);
            return root;
      }

      public static void printLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                System.out.print(node.val + " ");
                q.add(node.left);
                q.add(node.right);
            } else {
                System.out.print("null ");
            }
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.println("Level Order of Constructed Tree:");
        printLevelOrder(root); // Expected: 3 9 20 null null 15 7
    }
}
