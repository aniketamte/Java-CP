import java.util.*;

public class Leetcode105 {
      static class TreeNode {
            int data;
            TreeNode left;
            TreeNode right;

            TreeNode(int data) {
                  this.data = data;
                  this.left = null;
                  this.right = null;
            }
      }

      public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inOrderIndexMap.put(inorder[i], i);
        }
        return splitTree(preorder, inOrderIndexMap, 0, 0, inorder.length-1);
      }

      private TreeNode splitTree(int preorder[], Map<Integer, Integer> inOrderIndexMap, int rootIndex, int left, int right){
            TreeNode root = new TreeNode(preorder[rootIndex]);

            //create left and right subtree

            int mid = inOrderIndexMap.get(preorder[rootIndex]);
            if(mid > left){
                  root.left = splitTree(preorder, inOrderIndexMap, rootIndex+1, left, mid-1);
            }
            if(mid < right){
                  root.right = splitTree(preorder, inOrderIndexMap, rootIndex + mid - left + 1, mid+1, right);
            }
            return root;
      }

      public static void main(String[] args) {
            Leetcode105 treeBuilder = new Leetcode105();
            int[] preorder = { 3, 9, 20, 15, 7 };
            int[] inorder = { 9, 3, 15, 20, 7 };

            TreeNode root = treeBuilder.buildTree(preorder, inorder);

            // Print tree in level order to verify output
            printLevelOrder(root);
      }

      public static void printLevelOrder(TreeNode root) {
            if (root == null)
                  return;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                  TreeNode node = queue.poll();
                  if (node != null) {
                        System.out.print(node.data + " ");
                        queue.add(node.left);
                        queue.add(node.right);
                  } else {
                        System.out.print("null ");
                  }
            }
      }
}
