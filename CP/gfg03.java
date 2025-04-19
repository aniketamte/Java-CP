public class gfg03 {
      //GFG---> Day3
      //Reverse an Array
      public static void reverseArray(int nums[]){
            int start = 0;
            int end = nums.length-1;

            while(start<end){
                  int temp = nums[start];
                  nums[start] = nums[end];
                  nums[end] = temp;

                  start++;
                  end--;
            }
      }
      public static void printArray(int nums[]){
            for(int i=0; i<nums.length; i++){
                  System.out.print(nums[i] + " ");
            }
            System.out.println();
      }
      public static void main(String[] args) {
            int nums[] = {9,8,7,6,5,4,3,2,1};
            reverseArray(nums);
            printArray(nums);
      }
}
