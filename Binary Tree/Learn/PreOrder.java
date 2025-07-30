import java.util.*;

public class PreOrder {
      static class Node {
            int data;
            Node left, right;

            Node(int data) {
                  this.data = data;
                  this.left = null;
                  this.right = null;
            }
      }

      static class BinaryTree {
            static int index = -1;

            public static Node buildTree(int nodes[]) {
                  index++;
                  if (nodes[index] == -1) {
                        return null;
                  }
                  Node newNode = new Node(nodes[index]);
                  newNode.left = buildTree(nodes);
                  newNode.right = buildTree(nodes);
                  return newNode;
            }

            public static void preOrder(Node root) {
                  if (root == null) {
                        return;
                  }
                  System.out.print(root.data + " ");
                  preOrder(root.left);
                  preOrder(root.right);
            }

            public static void postOrder(Node root) {
                  if (root == null) {
                        return;
                  }
                  postOrder(root.left);
                  postOrder(root.right);
                  System.out.print(root.data + " ");
            }

            public static void inOrder(Node root) {
                  if (root == null) {
                        return;
                  }
                  inOrder(root.left);
                  System.out.print(root.data + " ");
                  inOrder(root.right);
            }

            // Level Order traversal --> (BFS)

            public static void levelOrder(Node root) {
                  if (root == null) {
                        return;
                  }
                  Queue<Node> queue = new LinkedList<>();
                  queue.add(root);
                  queue.add(null); // Level marker
                  while (!queue.isEmpty()) {
                        Node currentNode = queue.remove();
                        if (currentNode == null) {
                              System.out.println();
                              if (!queue.isEmpty()) {
                                    queue.add(null); // Add level marker for next level
                              } else {
                                    break; // No more nodes to process
                              }
                        } else {
                              System.out.print(currentNode.data + " ");
                              if (currentNode.left != null) {
                                    queue.add(currentNode.left);
                              }
                              if (currentNode.right != null) {
                                    queue.add(currentNode.right);
                              }
                        }
                  }
            }

            // Height of the tree

            public static int height(Node root) {
                  if (root == null) {
                        return 0;
                  }
                  int leftHeight = height(root.left);
                  int rightHeight = height(root.right);
                  return Math.max(leftHeight, rightHeight) + 1;
            }

            // count nodes in the tree
            public static int countNodes(Node root) {
                  if (root == null) {
                        return 0;
                  }
                  return countNodes(root.left) + countNodes(root.right) + 1;
            }

            // sum of all nodes in the tree
            public static int sumOfNodes(Node root) {
                  if (root == null) {
                        return 0;
                  }
                  return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
            }
      }

      public static void main(String[] args) {
            int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(nodes);
            System.out.println(root.data);

            System.out.print("PreOrder: ");
            tree.preOrder(root);
            System.out.println();

            System.out.print("PostOrder: ");
            tree.postOrder(root);
            System.out.println();

            System.out.print("InOrder: ");
            tree.inOrder(root);
            System.out.println();

            System.out.println("Level Order Traversal:");
            tree.levelOrder(root);
            System.out.println();

            System.out.println("Height of the tree: " + tree.height(root));

            System.out.println("Count of nodes in the tree: " + tree.countNodes(root));

            System.out.println("Sum of all nodes in the tree: " + tree.sumOfNodes(root));
      }
}