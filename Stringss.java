public class Stringss{
      /*
        1) Comarison Of String :-
           -> == method :-
              -> Checks if reference variable are pointing to same object
              -> when you need to check only value use .equal method

       */
      public static void main(String[] args) {
            String a = "Aniket";
            String b = "Aniket";

            // ==

            System.out.println( a == b);

            String name1 = new String("Amte");
            String name2 = new String("Amte");
            System.out.println(name1 == name2);
            System.out.println(name1.equals(name2));
      }
}