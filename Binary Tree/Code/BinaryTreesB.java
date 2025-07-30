
import java.util.*;

public class BinaryTreesB {
      static class Node {
            int data;
            Node left;
            Node right;

            Node(int data) {
                  this.data = data;
                  this.left = null;
                  this.right = null;
            }
      }

      static class BinaryTree {
            static int index = -1;

            public static Node buildTree(int node[]) {
                  index++;
                  if (node[index] == -1) {
                        return null;
                  }

                  Node newNode = new Node(node[index]);
                  newNode.left = buildTree(node);
                  newNode.right = buildTree(node);
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

            public static void inOrder(Node root) {
                  if (root == null) {
                        return;
                  }
                  inOrder(root.left);
                  System.out.print(root.data + " ");
                  inOrder(root.right);
            }

            public static void postOrder(Node root) {
                  if (root == null) {
                        return;
                  }
                  postOrder(root.left);
                  postOrder(root.right);
                  System.out.print(root.data + " ");

            }

            public static void levelOrder(Node root) {
                  if (root == null) {
                        return;
                  }
                  Queue<> q = new LinkedList<>();
                  q.add(root);
                  q.add(null);

                  while (!q.isEmpty()) {
                        Node currNode = q.remove();
                        if (currNode == null) {
                              System.out.println();
                              if (q.isEmpty()) {
                                    break;
                              } else {
                                    q.add(null);
                              }
                        } else {
                              System.out.print(currNode.data + " ");
                              if (currNode.left != null) {
                                    q.add(currNode.left);
                              }
                              if (currNode.right != null) {
                                    q.add(currNode.right);
                              }
                        }
                  }
            }

      
      }

      public static void main(String[] args) {
            int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(node);
            System.out.println(root.data);
            tree.preOrder(root);
            System.out.println();
            tree.inOrder(root);
            System.out.println();
            tree.postOrder(root);
            System.out.println();
            tree.levelOrder(root);
            // System.out.println();
            // tree.heightOfTree(root);
      }
}
