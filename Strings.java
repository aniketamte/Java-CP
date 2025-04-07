
import java.util.Scanner;

public class Strings{
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
      }
}