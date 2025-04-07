
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
            System.out.print("Display name : " + name);
      }
}