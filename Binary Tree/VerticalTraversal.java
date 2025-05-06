import java.util.*;

public class VerticalTraversal {
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
      public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();

            if (root == null) {
                  return ans;
            }

            int col = 0;

            Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>();
            Map<Integer, ArrayList<Integer>> map = new HashMap();

            queue.offer(new AbstractMap.SimpleEntry<>(root, col));

            int min = 0;
            int max = 0;

            while (!queue.isEmpty()) {
                  Map.Entry<TreeNode, Integer> removed = queue.poll();
                  root = removed.getKey();
                  col = removed.getValue();

                  if (root != null) {
                        if (!map.containsKey(col)) {
                              map.put(col, new ArrayList<Integer>());
                        }

                        map.get(col).add(root.val);

                        min = Math.min(min, col);
                        max = Math.max(max, col);

                        queue.offer(new AbstractMap.SimpleEntry<>(root.left, col - 1));
                        queue.offer(new AbstractMap.SimpleEntry<>(root.right, col + 1));
                  }
            }

            for (int i = min; i <= max; i++) {
                  ans.add(map.get(i));
            }

            return ans;
      }
      
      public static void main(String[] args) {
            VerticalTraversal solution = new VerticalTraversal();

            // Manually creating the tree:
            // 3
            // / \
            // 9 20
            // / \
            // 15 7

            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(9);
            root.right = new TreeNode(20);
            root.right.left = new TreeNode(15);
            root.right.right = new TreeNode(7);

            List<List<Integer>> result = solution.verticalTraversal(root);

            // Print the output
            for (List<Integer> level : result) {
                  System.out.println(level);
            }
      }

}
