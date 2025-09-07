import java.util.ArrayList;
public class MultiOcc {

      static ArrayList<Integer> list = new ArrayList<>();
      public static void multiOcc(int arr[], int target, int index){
            if(index == arr.length){
                  return;
            }
            if(arr[index] == target){
                  list.add(index);
            } 
            multiOcc(arr, target, index + 1);
      }
      public static void main(String[] args) {
            int arr[] = {2, 3, 1, 4, 4, 5};
            multiOcc(arr, 4, 0);
            System.out.println(list);
      }
}
