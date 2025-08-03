//✅ Example 3: super() with Constructor

class Person {
      Person() {
            System.out.println("Person is created");
      }
}

class Student extends Person {
      Student() {
            super(); // Call Person's constructor
            System.out.println("Student is created");
      }
}

public class Main3 {
      public static void main(String[] args) {
            Student s = new Student();
      }
}
