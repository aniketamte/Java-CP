public class InnerClass {
      public static void main(String[] args) {
            new Outer().myMethod(); // prints greeting
      }
}

class Outer {
      void myMethod() {
            class LocalInner { // local inner class
                  void greet() {
                        System.out.println("Hello from LocalInner");
                  }
            }
            LocalInner li = new LocalInner();
            li.greet();
      }
}
