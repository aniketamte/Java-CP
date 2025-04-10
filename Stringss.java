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

            //charAt method

            System.out.println(name1.charAt(0));

            System.out.println(56);
            Integer num = new Integer(56);
            System.out.println(num.toString());


            //Preety printing
              // -> % = placeholder

            float ab = 453.123f;
            //System.out.printf("Formatted number is %.1f", ab);

            System.out.println("PI value is : " + Math.PI);

            System.out.printf("Pie: %.3f", Math.PI);
            System.out.println();

            System.out.printf("Hello my name is %s and I am %s", "Aniket", "Student");

            System.out.println();

            //String concatenation Operator

            System.out.println('a' + 'b');   //Character value --->  a -> 97 and b -> 98  ====> 97 + 98 = 195

            System.out.println("a" + "b");  //ab  -> concatenate the string
      }
}