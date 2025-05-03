
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
      }

       public static void main(String[] args) {
            int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(node);
            System.out.println(root.data);
      }
}
