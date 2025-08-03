// class A {
//       void display() {
//             System.out.println("Hello from A");
//       }
// }

// class B extends A {
// }

// class C extends A {
// }

// // ❌ Java will NOT allow this
// class D extends B, C { } // Error: Java doesn't support multiple inheritance with classes


interface A {
      void show();
}

interface B extends A {
      void displayB();
}

interface C extends A {
      void displayC();
}

// D implements B and C (Hybrid Inheritance using interfaces)
class D implements B, C {
      public void show() {
            System.out.println("Hello from A");
      }

      public void displayB() {
            System.out.println("Hello from B");
      }

      public void displayC() {
            System.out.println("Hello from C");
      }
}

public class Main {
      public static void main(String[] args) {
            D obj = new D();
            obj.show(); // from A
            obj.displayB(); // from B
            obj.displayC(); // from C
      }
}
