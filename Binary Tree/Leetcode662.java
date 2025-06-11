import java.util.*;

public class Leetcode662 {
      static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int val) {
                  this.val = val;
            }
      }

      static class Pair<K, V> {
            private K key;
            private V value;

            Pair(K key, V value) {
                  this.key = key;
                  this.value = value;
            }

            public K getKey() {
                  return key;
            }

            public V getValue() {
                  return value;
            }
      }

      public static int widthOfBinaryTree(TreeNode root) {
            if (root == null)
                  return 0;

            Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
            queue.offer(new Pair<>(root, 0));
            int maxWidth = 0;

            while (!queue.isEmpty()) {
                  int levelSize = queue.size();
                  int levelStart = queue.peek().getValue();
                  int levelEnd = 0;

                  for (int i = 0; i < levelSize; i++) {
                        Pair<TreeNode, Integer> entry = queue.poll();
                        TreeNode node = entry.getKey();
                        int position = entry.getValue();
                        levelEnd = position;

                        if (node.left != null)
                              queue.offer(new Pair<>(node.left, position * 2));
                        if (node.right != null)
                              queue.offer(new Pair<>(node.right, position * 2 + 1));
                  }

                  maxWidth = Math.max(maxWidth, levelEnd - levelStart + 1);
            }

            return maxWidth;
      }

      // Helper to build tree from level order array input
      public static TreeNode buildTreeFromLevelOrder(Integer[] values) {
            if (values.length == 0 || values[0] == null)
                  return null;

            TreeNode root = new TreeNode(values[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 1;

            while (!queue.isEmpty() && i < values.length) {
                  TreeNode current = queue.poll();

                  if (i < values.length && values[i] != null) {
                        current.left = new TreeNode(values[i]);
                        queue.offer(current.left);
                  }
                  i++;

                  if (i < values.length && values[i] != null) {
                        current.right = new TreeNode(values[i]);
                        queue.offer(current.right);
                  }
                  i++;
            }

            return root;
      }

      public static void main(String[] args) {
            Integer[] input = { 1, 3, 2, 5, 3, null, 9 };

            TreeNode root = buildTreeFromLevelOrder(input);
            int width = widthOfBinaryTree(root);

            System.out.println("Maximum width of binary tree: " + width); // Expected: 4
      }
}
