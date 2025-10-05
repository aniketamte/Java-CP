import java.util.*;
public class iterarion {
      public static void main(String[] args) {
            HashMap<String, Integer> hm = new HashMap<>();

          //Insert
          hm.put("India", 100);
          hm.put("USA", 200);
          hm.put("Nepal", 300);
          hm.put("Indonesia", 500);
          hm.put("China", 600);

          Set<String> key = hm.keySet();
          System.out.println(key);

          for (String k : key) {
            System.out.println("Key = " + k + ", Value = " + hm.get(k));
          }
      }
}
