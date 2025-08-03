// Parent class
class Father {
      void display() {
            System.out.println("I am the Father.");
      }
}

// Child class (inherits Father)
class Son extends Father {
      void show() {
            System.out.println("I am the Son.");
      }
}

// Main class to run the code
public class Main {
      public static void main(String[] args) {
            Son s1 = new Son();

            s1.display(); // From Father class
            s1.show(); // From Son class
      }
}
