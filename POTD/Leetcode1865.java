import java.util.*;

public class Leetcode1865 {
      private List<Integer> nums1;
      private List<Integer> nums2;
      private Map<Integer, Integer> frequencyMap;

      public Leetcode1865(int[] nums1, int[] nums2) {
            this.nums1 = new ArrayList<>();
            for(int num : nums1){
                  this.nums1.add(num);
            }
            this.nums2 = new ArrayList<>();
            for(int num : nums2){
                  this.nums2.add(num);
            }
            frequencyMap = new HashMap<>();
            for(int num : nums2){
                  frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
      }

      public void add(int index, int val) {
            int oldVal = nums2.get(index);
            frequencyMap.put(oldVal, frequencyMap.get(oldVal) - 1);
            if (frequencyMap.get(oldVal) == 0) {
                  frequencyMap.remove(oldVal);
            }

            int newVal = oldVal + val;
            nums2.set(index, newVal);
            frequencyMap.put(newVal, frequencyMap.getOrDefault(newVal, 0) + 1);
      }

      public int count(int tot) {
            int count = 0;
            for (int num : nums1) {
                  int complement = tot - num;
                  count += frequencyMap.getOrDefault(complement, 0);
            }
            return count;
      }
      
      public static void main(String[] args) {
            Leetcode1865 obj = new Leetcode1865(
                        new int[] { 1, 1, 2, 2, 2, 3 },
                        new int[] { 1, 4, 5, 2, 5, 4 });

            List<Object> output = new ArrayList<>();
            output.add(null);
            output.add(obj.count(7));
            obj.add(3, 2);
            output.add(null);
            output.add(obj.count(8));
            output.add(obj.count(4));
            obj.add(0, 1);
            output.add(null);
            obj.add(1, 1);
            output.add(null);
            output.add(obj.count(7));

            System.out.println(output);
      }        
}
