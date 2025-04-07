
import java.util.Scanner;

public class Strings {

      //Find character index

      public static void printLetter(String str){
            for(int i=0; i<str.length(); i++){
                  System.out.print(str.charAt(i) + " ");
            }
            System.out.println();
      }

      //Check String is palindrome or not

      public static boolean isPalindrome(String str){
            for(int i=0; i<str.length()/2; i++){
                  int n = str.length();
                  if(str.charAt(i) != str.charAt(n-1-i)){
                        //Not a palindrome
                        return false;
                  }
            }
            return true;
      }

      //Question 2 ====> Shortest Path

      public static float getShortestPath(String path){
            int x = 0, y = 0;

            for(int i=0; i<path.length(); i++){
                  char dir = path.charAt(i);

                  //south
                  if(dir == 'S'){
                        y--;
                  } else if(dir == 'N'){ //North
                        y++;
                  } else if(dir == 'W'){ //West
                        x--;
                  } else{  //East
                        x++;
                  }
            }
            int X2 =  x * x;
            int Y2 =  y * y;
            return (float)Math.sqrt(X2 + Y2);
      }

      //String Functions ===> Substring

      public static String Substring(String str, int si, int ei){
            String substr = "";
            for(int i=si; i<ei; i++){
                  substr += str.charAt(i);
            }
            return substr;
      }

    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c', 'd'};
        String str = "abcd";
        String str2 = new String("XYZ");

        //Strings are immutable
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");

        //String name = sc.next();  --> use for print first single word
        String name = sc.nextLine();  //Use for print entire line
        System.out.println("Display name : " + name);

        //calculate name length
        System.out.println("Length : " + name.length());

        //Concatenation ==> Join two words
        String firstName = "Aniket";
        String lastName = "Amte";
        String fullName = firstName + " " + lastName;

        System.out.println("Full Name : " + fullName);

        //Find character index
        //System.out.println("Find Character at : " + fullName.charAt(8));

        printLetter("Find character index : " + fullName);

        //Check palindrome
        System.out.println(isPalindrome("raceacar"));

        //Que 2 ===> Shortest path
        System.out.println("Shortest Path : " + getShortestPath("WNEENESENNN"));

        //String Functions ===> Substring
        System.out.println("Substring : " + Substring("HelloWorld", 0, 4));
    }
}
