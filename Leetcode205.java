
public class Leetcode205 {

    public static boolean isIsomorphic(String s, String t) {
      //Base case
      if(s.length() != t.length()){
            return false;
      }

      int mappingS[] = new int[256];
      int mappingT[] = new int[256];

      for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            //if not mapped yetr store the mappihng

            if(mappingS[c1] == 0 && mappingT[c2] == 0){
                  mappingS[c1] = c2;
                  mappingT[c2] = c1;
            }

            //if already mapp
            else{
                  if (mappingS[c1] != c2 || mappingT[c2] != c1) {
                    return false;
                }
            }
      }
      return true;
    }
    public static void main(String[] args) {
      String s = "egg";
      String t = "add";

      System.out.println(isIsomorphic(s, t));
    }
}
