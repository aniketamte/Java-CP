public class Subset{
      public static void findSubset(String str, String ans, int index){
            if(index == str.length()){
                  if(ans.length() == 0){
                        System.out.println("NULL");
                  }
                  System.out.println(ans);
                  return;
            }
            findSubset(str, ans + str.charAt(index), index+1); // yes
            findSubset(str, ans, index+1);  //No
      }

      public static void main(String[] args) {
            String str = "abc";
            findSubset(str, "", 0);
      }
}