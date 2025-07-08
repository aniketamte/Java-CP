import java.util.ArrayList;
import java.util.Collections;

public class Swap {
      public static void swap(ArrayList<Integer> list, int idx1, int idx2){
            int temp = list.get(idx1);
            list.set(idx1, list.get(idx2));
            list.set(idx2, temp);
      }
      public static void main(String[] args) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);

            int idx1 = 3;
            int idx2 = 4;

            System.out.println(list);
            swap(list, idx1, idx2);
            System.out.println(list);

            Collections.sort(list);
            System.out.println(list); //Ascending

            Collections.sort(list, Collections.reverseOrder()); //Descending order
            System.out.println(list);
      }
}
