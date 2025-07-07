
import java.util.ArrayList;

public class MultiList {
      public static void main(String[] args) {
            ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(2);
            list1.add(3);
            list1.add(4);
            list1.add(5);

            mainList.add(list1);

            ArrayList<Integer> list2 = new ArrayList<>();
            list2.add(6);
            list2.add(7);
            list2.add(8);
            list2.add(9);
            list2.add(10);

            mainList.add(list2);

            System.out.println(mainList);
      }
}
