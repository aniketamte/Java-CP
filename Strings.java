
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
    }
}
