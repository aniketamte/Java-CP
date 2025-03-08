public class FlatteningLL{
      class Node{
            int data;
            Node next;
            Node bottom;

            Node(int x){
                  data = x;
                  next = null;
                  bottom = null;
            }
      }
      Node mergeTwoList(Node a, Node b) {
        Node data = new Node(0);
        Node res = data;

        while (a != null && b != null) {
            if (a.data < b.data) {
                data.bottom = a;
                data = data.bottom;
                a = a.bottom;
            } else {
                data.bottom = b;
                data = data.bottom;
                b = b.bottom;
            }
        }
        if (a != null) {
            data.bottom = a; 
        }else {
            data.bottom = b;
        }
        return res.bottom;
    }

    Node flatten(Node root) {
        // code here
        if (root == null || root.next == null) {
            return root;
        }
        root.next = flatten(root.next);
        root = mergeTwoList(root, root.next);
        return root;
    }
}