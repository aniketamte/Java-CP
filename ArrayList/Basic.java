import java.util.ArrayList;

public class Basic {
      public static void main(String[] args) {
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<String> list2 = new ArrayList<>();
            ArrayList<Boolean> list3 = new ArrayList<>();

            list1.add(1);
            list1.add(2);
            list1.add(3);
            list1.add(1, 9);
            list2.add("a");
            list2.add("b");
            list2.add("c");
            list3.add(true);
            list3.add(false);
            list3.add(true);
            System.out.println(list1);
            System.out.println(list2);
            System.out.println(list3);

            //Get Operation
            int element = list1.get(2);
            System.out.println(element + " is the element at index 2");

            //Remove element
            list1.remove(1);
            System.out.println(list1);

            //Set Operation
            list1.set(1, 10);
            System.out.println(list1);

            //contains element
            System.out.println(list1.contains(10) );
            System.out.println(list1.contains(11));

            //Size of the list
            System.out.println(list1.size());

            //Print the ArrayList
            for(int i=0; i<list1.size(); i++){
                  System.out.print(list1.get(i) + " ");
            }
            System.out.println();
      }
}
