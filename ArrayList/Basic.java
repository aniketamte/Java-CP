import java.util.ArrayList;

public class Basic {
      public static void main(String[] args) {
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<String> list2 = new ArrayList<>();
            ArrayList<Boolean> list3 = new ArrayList<>();

            list1.add(1);
            list1.add(2);
            list1.add(3);
            list1.add(4);
            list1.add(5);
            list1.add(6);
            list1.add(7);

            list1.add(1, 9);

            list2.add("a");
            list2.add("b");
            list2.add("c");
            list2.add("d");
            list2.add("e");

            list3.add(true);
            list3.add(false);
            list3.add(true);

            System.out.println(list1);
            System.out.println(list2);
            System.out.println(list3);

            // Get Operation
            int element = list1.get(2);
            System.out.println(element + " is the element at index 2");

            // Remove element
            list1.remove(1);
            System.out.println(list1);

            // Set Operation
            list1.set(1, 10);
            System.out.println(list1);

            // contains element
            System.out.println(list1.contains(10));
            System.out.println(list1.contains(11));

            // Size of the list
            System.out.println(list1.size());

            // Print the ArrayList
            for (int i = 0; i < list1.size(); i++) {
                  System.out.print(list1.get(i) + " ");
            }
            System.out.println();

            // Reverse the ArrayList
            for (int i = list1.size() - 1; i >= 0; i--) {
                  System.out.print(list1.get(i) + " ");
            }
            System.out.println();

            // Find maxiumum element in the ArrayList

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < list1.size(); i++) {
                  if (list1.get(i) > max) {
                        max = list1.get(i);
                  }
            }
            System.out.println("Maximum element in the ArrayList is => " + max);

            
      }
}
