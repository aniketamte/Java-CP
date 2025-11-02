
import java.util.Stack;

public class NGE{
      public static void main(String[] args) {
            int arr[] = {6, 8, 0, 1, 3};
            Stack<Integer> s = new Stack<>();
            int mextGE[] = new int[arr.length];

            for(int i=arr.length-1; i>=0; i--){
                  while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                        s.pop();
                  }
                  if(s.isEmpty()){
                        mextGE[i]=-1;
                  } else{
                        mextGE[i] = arr[s.peek()];
                  }
                  s.push(i);
            }

            for(int i=0; i<mextGE.length; i++){
                  System.out.print(mextGE[i] + " ");
            }
            System.out.println();
      }
}