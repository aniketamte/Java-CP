
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

            //System.out.println(mainList);

            for(int i=0; i<mainList.size(); i++){
                  ArrayList<Integer> currList = mainList.get(i);
                  for(int j=0; j<currList.size(); j++){
                        System.out.print(currList.get(j) + " ");
                  }
                  System.out.println();
            }

            System.out.println(mainList);

            ArrayList<Integer> list3 = new ArrayList<>();
            ArrayList<Integer> list4 = new ArrayList<>();
            ArrayList<Integer> list5 = new ArrayList<>();

            for(int i=1; i<=5; i++){
                  list3.add(i*1);
                  list4.add(i*2);
                  list5.add(i*3);
            }

            mainList.add(list3);
            mainList.add(list4);
            mainList.add(list5);

            System.out.println(mainList);
      }
}
