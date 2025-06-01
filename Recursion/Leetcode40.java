import java.util.*;
public class Leetcode40 {
      public static void solve(int candidates[], int target, List<Integer> current, int idx, List<List<Integer>> result){
            if(target < 0){
                  return;
            }
            if(target == 0){
                  result.add(new ArrayList<>(current));
                  return;
            }

            for(int i=idx; i<candidates.length; i++){
                  if(i > idx && candidates[i] == candidates[i-1]){
                        continue;
                  }
                  current.add(candidates[i]); //DO
                  solve(candidates, target-candidates[i], current, i+1, result);
                  current.remove(current.size() - 1);
            }
      }
      public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> current = new ArrayList<>();     
            Arrays.sort(candidates);
            solve(candidates, target, current, 0, result);
            return result;
      }
      
      public static void main(String[] args) {
            int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
            int target = 8;
            List<List<Integer>> combinations = combinationSum2(candidates, target);
            System.out.println("Unique combinations that sum to " + target + ":");
            for (List<Integer> combo : combinations) {
                  System.out.println(combo);
            }
      }
}