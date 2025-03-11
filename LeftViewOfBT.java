
import java.util.ArrayList;
import java.util.List;

class Node {

    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class LeftViewOfBT {

    public static List<Integer> leftsideView(Node root) {
        List<Integer> res = new ArrayList<>();
        recursionLeft(root, 0, res);
        return res;
    }

    private static void recursionLeft(Node root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(root.data);
        }
        recursionLeft(root.left, level + 1, res);
        recursionLeft(root.right, level + 1, res);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);

        // Getting the left view
        List<Integer> leftView = leftsideView(root);

        // Printing the left view
        System.out.println("Left View of the Binary Tree: " + leftView);
    }
}
