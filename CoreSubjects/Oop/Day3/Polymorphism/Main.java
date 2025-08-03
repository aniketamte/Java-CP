//✅ 1. Compile-Time Polymorphism (Method Overloading)

class MathOperations {
      void add(int a, int b) {
            System.out.println(a + b);
      }

      void add(double a, double b) {
            System.out.println(a + b);
      }
}

public class Main {
      public static void main(String[] args) {
            MathOperations obj = new MathOperations();
            obj.add(2, 3); // Calls int version
            obj.add(2.5, 3.5); // Calls double version
      }
}
