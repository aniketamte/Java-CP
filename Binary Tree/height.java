
public class height {
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

      public static int heightOfTree(Node root) {
            if (root == null) {
                  return 0;
            }

            int lh = heightOfTree(root.left);
            int rh = heightOfTree(root.right);
            return Math.max(lh, rh) + 1;
      }
      public static int count(Node root){
            if(root == null){
                  return 0;
            }
            int lcount = count(root.left);
            int rcount = count(root.right);
            return lcount + rcount + 1;
      }
      public static int sum(Node root){
            if (root == null) {
                  return 0;
            }
            int lsum = sum(root.left);
            int rsum = sum(root.right);
            return lsum + rsum + root.data;
      }
      public static int diameter(Node root){
            if (root == null) {
                  return 0;
            }                   
            int lDiam = diameter(root.left);
            int rDiam = diameter(root.right);
            int lHeight = heightOfTree(root.left);
            int rHeight = heightOfTree(root.right);
            int selfDiam = lHeight + rHeight + 1;

            return Math.max(selfDiam, Math.max(lDiam, rDiam));
      }
      public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);

            System.out.println(heightOfTree(root));
            System.out.println(count(root));
            System.out.println(sum(root));
            System.out.println(diameter(root));
      }
}
