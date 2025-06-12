import java.util.*;

public class Leetcode863 {
      static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                  val = x;
            }
      }

      Map<TreeNode, TreeNode> parent = new HashMap<>();

      public void inorder(TreeNode root) {
            if (root == null)
                  return;
            if (root.left != null) {
                  parent.put(root.left, root);
                  inorder(root.left);
            }
            if (root.right != null) {
                  parent.put(root.right, root);
                  inorder(root.right);
            }
      }

      private void collectKDistanceNodes(TreeNode target, int k, List<Integer> result) {
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();

            queue.offer(target);
            visited.add(target);

            while (!queue.isEmpty()) {
                  if (k == 0)
                        break;
                  int size = queue.size();

                  for (int i = 0; i < size; i++) {
                        TreeNode current = queue.poll();

                        if (current.left != null && !visited.contains(current.left)) {
                              queue.offer(current.left);
                              visited.add(current.left);
                        }

                        if (current.right != null && !visited.contains(current.right)) {
                              queue.offer(current.right);
                              visited.add(current.right);
                        }

                        if (parent.containsKey(current) && !visited.contains(parent.get(current))) {
                              queue.offer(parent.get(current));
                              visited.add(parent.get(current));
                        }
                  }

                  k--;
            }

            while (!queue.isEmpty()) {
                  result.add(queue.poll().val);
            }
      }

      public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            List<Integer> result = new ArrayList<>();
            inorder(root);
            collectKDistanceNodes(target, k, result);
            return result;
      }

      public static void main(String[] args) {
            /*
             * Tree structure:
             * 3
             * / \
             * 5 1
             * / \ / \
             * 6 2 0 8
             * / \
             * 7 4
             */

            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(5);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(6);
            root.left.right = new TreeNode(2);
            root.right.left = new TreeNode(0);
            root.right.right = new TreeNode(8);
            root.left.right.left = new TreeNode(7);
            root.left.right.right = new TreeNode(4);

            TreeNode target = root.left; // node with value 5
            int k = 2;

            Leetcode863 solution = new Leetcode863();
            List<Integer> result = solution.distanceK(root, target, k);

            System.out.println("Nodes at distance " + k + " from target: " + result);
      }
}
