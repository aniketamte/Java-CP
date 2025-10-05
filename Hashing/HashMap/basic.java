import java.util.*;
public class basic{
      public static void main(String[] args) {
          HashMap<String, Integer> hm = new HashMap<>();

          //Insert
          hm.put("India", 100);
          hm.put("USA", 200);
          hm.put("Nepal", 300);

          System.out.println(hm); 

          //Get - O(1)
          int population = hm.get("India");
          System.out.println(population);

          System.out.println(hm.get("Indonesia")); //null

          //ContainsKey - O(1)
          System.out.println(hm.containsKey("India")); //true;
          System.out.println(hm.containsKey("Indonesia")); //false

          //Remove
          System.out.println(hm.remove("Nepal"));
          System.out.println(hm);

          //size
          System.out.println(hm.size());

          //isEmpty
          System.out.println(hm.isEmpty());

          //clear
          hm.clear();
          System.out.println(hm.isEmpty());
      }
}