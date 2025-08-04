// File: Main.java

// 👻 Abstract class - can't create object from this directly
abstract class Animal {
      // Abstract method - no body, only idea
      abstract void sound();

      // Normal method
      void eat() {
            System.out.println("Animals eat food");
      }
}

// 🐶 Subclass gives the actual implementation of the method
class Dog extends Animal {
      void sound() {
            System.out.println("Dog barks");
      }
}

class Cat extends Animal {
      void sound() {
            System.out.println("Cat meows");
      }
}

public class Main {
      public static void main(String[] args) {
            Dog d = new Dog();
            d.sound(); // Output: Dog barks
            d.eat(); // Output: Animals eat food

            Cat c = new Cat();
            c.sound(); // Output: Cat meows
            c.eat(); // Output: Animals eat food
      }
}
