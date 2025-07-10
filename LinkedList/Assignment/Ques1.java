public class Ques1 {
      public static class Node {
            int data;
            Node next;

            public Node(int d) {
                  data = d;
                  next = null;
            }
      }

      public static Node getIntersectionNode(Node h1, Node h2) {
            while (h2 != null) {
                  Node temp = h1;
                  while (temp != null) {
                        if (temp == h2) {
                              return h2;
                        }
                        temp = temp.next;
                  }
                  h2 = h2.next;
            }
            return null;
      }

      public static void main(String[] args) {
            Node h1, h2;
            h1 = new Node(10);
            h2 = new Node(3);

            Node newNode = new Node(6);
            h2.next = newNode;
            newNode = new Node(9);
            h2.next.next = newNode;

            newNode = new Node(15);
            h1.next = newNode;
            h2.next.next.next = newNode;

            newNode = new Node(30);
            h1.next.next = newNode;
            h1.next.next.next = null;

            Node intersectionPoint = getIntersectionNode(h1, h2);
            if (intersectionPoint == null) {
                  System.out.print("No Intersection Point\n");
            } else {
                  System.out.print("Intersection Point: " + intersectionPoint.data);
            }
      }
}
