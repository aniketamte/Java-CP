// Parent class
class Animal {
      void eat() {
            System.out.println("This animal eats food.");
      }
}

// Child class 1
class Dog extends Animal {
      void bark() {
            System.out.println("Dog barks.");
      }
}

// Child class 2
class Cat extends Animal {
      void meow() {
            System.out.println("Cat meows.");
      }
}

// Main class
public class Main {
      public static void main(String[] args) {
            Dog d = new Dog();
            d.eat(); // from Animal
            d.bark(); // from Dog

            Cat c = new Cat();
            c.eat(); // from Animal
            c.meow(); // from Cat
      }
}
