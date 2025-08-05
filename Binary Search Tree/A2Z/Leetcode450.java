import java.util.LinkedList;
import java.util.Queue;

public class Leetcode450 {
      static class TreeNode {
            int val;
            TreeNode left, right;

            TreeNode(int val) {
                  this.val = val;
                  this.left = null;
                  this.right = null;
            }
      }

      public static TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                  return null;
            }

            if (root.val == key) {
                  return helper(root);
            }

            TreeNode dummy = root;
            while (root != null) {
                  if (root.val > key) {
                        if (root.left != null && root.left.val == key) {
                              root.left = helper(root.left);
                              break;
                        } else {
                              root = root.left;
                        }
                  } else {
                        if (root.right != null && root.right.val == key) {
                              root.right = helper(root.right);
                              break;
                        } else {
                              root = root.right;
                        }
                  }
            }
            return dummy;
      }

      public static TreeNode helper(TreeNode root) {
            if (root.left == null) {
                  return root.right;
            } else if (root.right == null) {
                  return root.left;
            } else {
                  TreeNode leftChild = root.left;
                  TreeNode lastLeft = findLastLeft(root.right);
                  lastLeft.left = leftChild;
                  return root.right;
            }
      }

      public static TreeNode findLastLeft(TreeNode root) {
            if (root.left == null) {
                  return root;
            }
            return findLastLeft(root.left);
      }

      public static void printLevelOrder(TreeNode root) {
            if (root == null)
                  return;

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
            // Construct the tree [5,3,6,2,4,null,7]
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(3);
            root.right = new TreeNode(6);
            root.left.left = new TreeNode(2);
            root.left.right = new TreeNode(4);
            root.right.right = new TreeNode(7);

            int key = 3;

            TreeNode updatedRoot = deleteNode(root, key);
            System.out.println("Level Order of tree after deleting " + key + ":");
            printLevelOrder(updatedRoot); // ✅ Should print: 5 4 6 2 null null 7
      }
}
