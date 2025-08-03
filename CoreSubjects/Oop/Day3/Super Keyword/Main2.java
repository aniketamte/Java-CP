//✅ Example 2: super with Method
class Animal {
      void sound() {
            System.out.println("Animal sound");
      }
}

class Dog extends Animal {
      void sound() {
            super.sound(); // Use parent's sound method
            System.out.println("Dog barks");
      }
}

public class Main2 {
      public static void main(String[] args) {
            Dog d = new Dog();
            d.sound();
      }
}
