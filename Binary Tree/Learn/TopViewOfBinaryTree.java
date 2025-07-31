
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfBinaryTree {
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

      static class Info {
            TreeNode node;
            int horizontalDistance;

            public Info(TreeNode node, int horizontalDistance) {
                  this.node = node;
                  this.horizontalDistance = horizontalDistance;
            }
      }

      public static void TopView(TreeNode root) {
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer, TreeNode> map = new HashMap<>();
            int min = 0, max = 0;
            q.add(new Info(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                  Info curr = q.remove();
                  if (curr == null) {
                        if (q.isEmpty()) {
                              break;
                        } else {
                              q.add(null);
                        }
                  } else {
                        if (!map.containsKey(curr.horizontalDistance)) {
                              map.put(curr.horizontalDistance, curr.node);
                        }
                        if (curr.node.left != null) {
                              q.add(new Info(curr.node.left, curr.horizontalDistance - 1));
                              min = Math.min(min, curr.horizontalDistance - 1);
                        }
                        if (curr.node.right != null) {
                              q.add(new Info(curr.node.right, curr.horizontalDistance + 1));
                              max = Math.max(max, curr.horizontalDistance + 1);
                        }
                  }
            }
            for (int i = min; i <= max; i++) {
                  System.out.print(map.get(i).val + " ");
            }
            System.out.println();
      }

      public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);

            TopView(root);
      }
}
