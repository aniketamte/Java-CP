//✅ 2. Runtime Polymorphism (Method Overriding)

class Animal {
      void sound() {
            System.out.println("Animal makes sound");
      }
}

class Dog extends Animal {
      @Override
      void sound() {
            System.out.println("Dog barks");
      }
}

public class Main2 {
      public static void main(String[] args) {
            Animal obj = new Dog(); // Parent class reference, child class object
            obj.sound(); // Calls Dog's sound()
      }
}
