// File: Main.java

class Student {
      // 🔐 Private = hidden from outside the class
      private String name;
      private int age;

      // 🛠️ Setter = to set the value (write)
      public void setName(String n) {
            name = n;
      }

      public void setAge(int a) {
            if (a > 0) { // age must be positive
                  age = a;
            } else {
                  System.out.println("Age must be greater than 0");
            }
      }

      // 📖 Getter = to get the value (read)
      public String getName() {
            return name;
      }

      public int getAge() {
            return age;
      }
}

public class Main {
      public static void main(String[] args) {
            Student s = new Student(); // 🧒 Create object

            // Set values safely using setter methods
            s.setName("Aniket");
            s.setAge(20);

            // Get values using getter methods
            System.out.println("Name: " + s.getName());
            System.out.println("Age: " + s.getAge());

            // Try setting wrong value
            s.setAge(-5); // ❌ Won’t allow
      }
}
